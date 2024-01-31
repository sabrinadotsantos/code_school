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
import androidx.fragment.app.Fragment
import com.example.vsconnect_kotlin.R
import com.example.vsconnect_kotlin.apis.EndpointInterface
import com.example.vsconnect_kotlin.apis.RetrofitConfig
import com.example.vsconnect_kotlin.databinding.FragmentEditarImagemBinding
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        iconeLapis.setOnClickListener{
            mostrarOpcoesEscolhaImagem()
        }

        return root
    }

    private fun buscarUsuarioPorID(idUsuario: String){
        endpoints.buscarUsuarioPorID(UUID.fromString(idUsuario)).enqueue(
            object : Callback<JsonObject>{
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    val root: View = binding.root

                    val viewImagemPerfil = root.findViewById<ImageView>(R.id.id_view_imagem_perfil)

                    val imagemPerfilUsuario = JSONObject(response.body().toString()).getString("url_img")

                    val urlImagem = "http://172.16.52.183:8099/img/" + imagemPerfilUsuario

                    Picasso.get().load(urlImagem).into(viewImagemPerfil)

                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {

                }

            }
        )
    }

    private fun mostrarOpcoesEscolhaImagem(){
        val escolherImagemIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        val capturarImagemIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        val  escolherImagemTitulo = resources.getString(R.string.escolher_imagem)
        val  capturarImagemTitulo = resources.getString(R.string.capturar_imagem)

        val intentEscolhaImagem = Intent.createChooser(escolherImagemIntent, escolherImagemTitulo)

        intentEscolhaImagem.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayListOf(capturarImagemIntent))

        startActivityForResult(intentEscolhaImagem, IMAGEM_PERFIL_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val view_imagem_perfil = view?.findViewById<ImageView>(R.id.id_view_imagem_perfil)

        if (requestCode == IMAGEM_PERFIL_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data?.data != null) {
                val imagemSelecionadaUri = data.data

                val inputStream: InputStream? = requireContext().contentResolver.openInputStream(imagemSelecionadaUri!!)

                val imagemSelecionadaBitMap = BitmapFactory.decodeStream(inputStream)

                view_imagem_perfil?.setImageURI(imagemSelecionadaUri)

                atualizarImagemPerfil(imagemSelecionadaBitMap)

            }

        } else if (data?.action == "inline-data") {
            val imagemCapturada = data?.extras?.get("data") as Bitmap
            view_imagem_perfil?.setImageBitmap(imagemCapturada)

            atualizarImagemPerfil(imagemCapturada)

        }

    }

    private fun atualizarImagemPerfil(imagem: Bitmap){
        val idUsuario = requireContext()



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}