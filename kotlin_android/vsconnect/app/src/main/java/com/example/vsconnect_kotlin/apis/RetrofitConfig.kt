package com.example.vsconnect_kotlin.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    companion object{
        fun obterInstanciaRetrofit(url: String = ""): Retrofit
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(G)


    }
}