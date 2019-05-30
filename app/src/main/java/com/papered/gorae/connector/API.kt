package com.papered.gorae.connector

import com.google.gson.JsonObject
import com.papered.gorae.model.CouponModel
import com.papered.gorae.model.QuizModel
import retrofit2.Call
import retrofit2.http.*

interface API {

    @POST("auth/{deviceUUID}")
    fun auth(@Path("deviceUUID") deviceUUID: String, @Body body: HashMap<String, Any>): Call<Unit>

    @GET("coupon")
    @Headers("Content-Type: application/json")
    fun getCoupon(@Header("deviceUUID") deviceUUID: String): Call<ArrayList<CouponModel>>

    @HTTP(method = "DELETE", path = "coupon", hasBody = true)
    @Headers("Content-Type: application/json")
    fun deleteCoupon(@Header("deviceUUID") deviceUUID: String, @Body body: Any?): Call<Unit>

    @GET("team/check")
    fun checkTeam(): Call<JsonObject>

    @POST("team")
    fun joinTeam(@Body body: HashMap<String, String>): Call<Unit>

    @GET("solve/{booth}")
    fun getQuiz(@Path("booth") booth: String): Call<QuizModel>

    @POST("solve/{booth}")
    fun solveQuiz(@Path("booth") booth: String, @Body body: HashMap<String, String>): Call<Unit>
}

