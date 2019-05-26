package com.papered.gorae.connector

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .addInterceptor(interceptor)
    .build()

val retrofit = Retrofit
    .Builder()
    .baseUrl("url will here!")
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

val api = retrofit.create(API::class.java)

