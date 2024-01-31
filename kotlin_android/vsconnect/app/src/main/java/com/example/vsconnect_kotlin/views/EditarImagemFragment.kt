package com.example.vsconnect_kotlin.views

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.vsconnect_kotlin.R
import com.example.vsconnect_kotlin.apis.EndpointInterface
import com.example.vsconnect_kotlin.apis.RetrofitConfig
import com.example.vsconnect_kotlin.databinding.FragmentEditarImagemBinding
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.*

class EditarImagemFragment : Fragment() {

    private var _binding: FragmentEditarImagemBinding? = null
    private val binding get() = _binding!!

    private val clienteRetrofit = RetrofitConfig.obterInstanciaRetrofit()

    private val endpoints = clienteRetrofit.create(EndpointInterface::class.java)

    private val IMAGEM_PERFIL_REQUEST_CODE = 123

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEditarImagemBinding.inflate(inflater, container, false)

        val root: View = binding.root

        val sharedPreferences = requireContext().getSharedPreferences("idUsuario", Context.MODE_PRIVATE)

        val idUsuario = sharedPreferences.getString("idUsuario", "")

        buscarUsuarioPorID(idUsuario.toString())

        val iconeLapis = root.findViewById<ImageView>(R.id.icone_lapis)

        iconeLapis.setOnClickListener {
            mostrarOpcoesEscolhaImagem()
        }

        return root
    }

    private fun buscarUsuarioPorID(idUsuario: String) {
        endpoints.buscarUsuarioPorID(UUID.fromString(idUsuario)).enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val root: View = binding.root

                val viewImagemPerfil = root.findViewById<ImageView>(R.id.id_view_imagem_perfil)

                val imagemPerfilUsuario = JSONObject(response.body().toString()).getString("url_img")

                val urlImagem = "http://172.16.27.219:8099/img/" + imagemPerfilUsuario

                // Usar Picasso para carregar e exibir a imagem na ImageView
                Picasso.get().load(urlImagem).into(viewImagemPerfil)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun mostrarOpcoesEscolhaImagem(){
        // Criar Intents para escolher uma imagem da galeria ou capturar uma nova pela câmera
        val escolherImagemIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        val capturarImagemIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        // Obter os títulos para as opções de escolha de imagem
        val escolherImagemTitle = resources.getString(R.string.escolher_imagem)
        val capturarImagemTitle = resources.getString(R.string.capturar_imagem)

        // Criar um Intent Chooser para oferecer opções entre galeria e câmera
        val intentEscolhaImagem = Intent.createChooser(escolherImagemIntent, escolherImagemTitle)
        intentEscolhaImagem.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(capturarImagemIntent))

        // Iniciar a atividade esperando um resultado
        startActivityForResult(intentEscolhaImagem, IMAGEM_PERFIL_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val view_imagem_perfil = view?.findViewById<ImageView>(R.id.id_view_imagem_perfil)

        if (requestCode == IMAGEM_PERFIL_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            if (data?.data != null){
                val imagemSelecionadaUri = data.data

                val inputStream: InputStream? = requireContext().contentResolver.openInputStream(imagemSelecionadaUri!!)

                val imagemSelecionadaBitmap = BitmapFactory.decodeStream(inputStream)

                view_imagem_perfil?.setImageURI(imagemSelecionadaUri)

                atualizarImagemPerfil(imagemSelecionadaBitmap)

            }else if (data?.action == "inline-data"){
                // Imagem capturada pela câmera
                val imagemCapturada = data.extras?.get("data") as Bitmap
                view_imagem_perfil?.setImageBitmap(imagemCapturada)

                atualizarImagemPerfil(imagemCapturada)
            }
        }
    }

    private fun atualizarImagemPerfil(imagem: Bitmap){
        // Obter o ID do usuário armazenado nas preferências compartilhadas
        val idUsuario = requireContext().getSharedPreferences("idUsuario", Context.MODE_PRIVATE)
            .getString("idUsuario", "")

        // Criar um arquivo temporário para armazenar a imagem
        val file = File(requireContext().cacheDir, "temp_image.png")
        file.createNewFile()

        // Salvar a imagem Bitmap no arquivo temporário
        val outputStream = FileOutputStream(file)
        imagem.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        outputStream.close()

        // Criar partes Multipart para a imagem
        val requestFile = RequestBody.create(MediaType.parse("image/*"), file)
        val imagemPart = MultipartBody.Part.createFormData("imagem", file.name, requestFile)

        endpoints.editarImagemUsuario(imagemPart, UUID.fromString(idUsuario)).enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                // Exibir mensagem de sucesso
                Toast.makeText(requireContext(), "Foto atualizada com sucesso!!!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                // Exibir mensagem de erro
                Toast.makeText(requireContext(), "Erro ao atualizar imagem de Perfil.", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}