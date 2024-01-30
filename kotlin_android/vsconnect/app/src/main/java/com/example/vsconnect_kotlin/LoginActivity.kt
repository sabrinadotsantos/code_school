package com.example.vsconnect_kotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.vsconnect_kotlin.databinding.ActivityLoginBinding
import com.example.vsconnect_kotlin.MainActivity
import com.example.vsconnect_kotlin.apis.EndpointInterface
import com.example.vsconnect_kotlin.apis.RetrofitConfig
import com.example.vsconnect_kotlin.models.Login
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.nio.charset.StandardCharsets
import java.util.*

class LoginActivity : AppCompatActivity() {

    //É um propriedade privada como o nome binding do tipo ActivityLoginBinding
    private lateinit var binding: ActivityLoginBinding

    private val clienteRetrofit = RetrofitConfig.obterInstanciaRetrofit()

    private val endpoints = clienteRetrofit.create(EndpointInterface:: class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        val sharedPreferences = getSharedPreferences("idUsuario", Context.MODE_PRIVATE )

        val editor = sharedPreferences.edit()

        editor.remove("idUsuario")

        editor.apply()

        binding.btnEntrar.setOnClickListener {

          autenticarUsuario()

        }
        setContentView(binding.root)


    }

    private fun autenticarUsuario(){
        val root: View = binding.root

        val idEmail = root.findViewById<EditText>(R.id.campo_email)
        val idSenha = root.findViewById<EditText>(R.id.campo_senha)

        val emailDigitado = idEmail.text.toString()
        val senhaDigitado = idSenha.text.toString()

        val usuario = Login(emailDigitado, senhaDigitado)

        endpoints.login(usuario).enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
               when(response.code()){
                   200 -> {
                       val idUsuario = decodificarToken(response.body().toString())

                       val sharedPreferences = getSharedPreferences("idUsuario", Context.MODE_PRIVATE)

                       val editor = sharedPreferences.edit()

                       editor.putString("idUsuario", idUsuario.toString())

                       editor.apply()

                       //direcionado o usuário para tela lista de serviços

                       val mainIntent = Intent(this@LoginActivity, MainActivity::class.java)

                       startActivity(mainIntent)

                       finish()

                   }
                   403 -> {tratarFalhaNaAutenticacao("Email e/ou senha inválidos.")}
                   else -> {tratarFalhaNaAutenticacao("Falha ao se logar!")}
               }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                tratarFalhaNaAutenticacao("Falha ao tentar se logar!")
            }

        })

    }

    private fun tratarFalhaNaAutenticacao(mensagemErro: String){
        Toast.makeText(this, mensagemErro, Toast.LENGTH_SHORT).show()
    }

    private fun decodificarToken(token: String): Any {
        val partes = token.split(".")
        val payloadBase64 = partes[1]

        val payloadBytes = Base64.getUrlDecoder().decode(payloadBase64)
        val payloadJson = String(payloadBytes, StandardCharsets.UTF_8)

        val json = JSONObject(payloadJson)
        return json["idUsuario"].toString()
    }

}