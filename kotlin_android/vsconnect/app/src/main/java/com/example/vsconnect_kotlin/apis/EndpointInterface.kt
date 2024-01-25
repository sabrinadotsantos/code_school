package com.example.vsconnect_kotlin.apis

import com.example.vsconnect_kotlin.models.Servico
import retrofit2.Call
import retrofit2.http.GET

interface EndpointInterface {
    @GET("servicos")
    fun listarServicos() : Call<List<Servico>>

}