package com.example.sp22_bse_6a_demo.remote_configuration

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIConfiguration {

    companion object {
        var retrofit: Retrofit? = null
        val baseUrl = "https://www.freetestapi.com"
        fun getClient(): Retrofit? {
            if(retrofit == null) {
                val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            }
            return retrofit
        }
    }

}
