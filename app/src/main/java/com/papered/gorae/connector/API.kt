package com.papered.gorae.connector

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface API {
    @POST("auth/{deviceUUID}")
    fun auth(@Path("deviceUUID") deviceUUID: String, @Body body: HashMap<String, Any>): Call<Unit>
}
