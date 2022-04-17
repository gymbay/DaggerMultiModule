package ru.gymbay.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.gymbay.core.network.MoexService
import ru.gymbay.network.services.MoexServiceImpl

class NetworkProvider {

    private val retrofit = buildRetrofit()

    private fun buildRetrofit(): Retrofit {
        val okHttp = OkHttpClient()

        return Retrofit.Builder()
            .client(okHttp)
            .baseUrl(URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun createMoexService(): MoexService = retrofit.create(MoexServiceImpl::class.java)

    companion object {
        const val URL = "https://iss.moex.com/iss/"
    }

}