package com.example.vsconnect_kotlin.apis

import com.example.vsconnect_kotlin.models.Login
import com.example.vsconnect_kotlin.models.Servico
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import java.util.UUID

interface EndpointInterface {
    @GET("servicos")
    fun listarServicos() : Call<List<Servico>>

    @POST("login")
    fun login (@Body usuario: Login) : Call<JsonObject>

    @GET("usuarios/{idUsuario}")

    fun buscarUsuarioPorID(@Path(value =  "idUsuario", encoded = true) idUsuario:UUID): Call<JsonObject>

    @Multipart
    @PUT("usuarios/editarImagem/{idUsuario}")

    fun editarImagemUsuario(
        @Part imagem: MultipartBody.Part,
        @Path (value =  "idUsuario", encoded = true) idUsuario: UUID ) : Call<JsonObject>

}