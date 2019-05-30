package com.papered.gorae.connector

import com.papered.gorae.model.CouponModel
import com.papered.gorae.model.StampModel
import retrofit2.Call
import retrofit2.http.*

interface API {

    @GET("coupon")
    @Headers("Content-Type: application/json")
    fun getCoupon(@Header("deviceUUID") deviceUUID: String): Call<ArrayList<CouponModel>>

    @HTTP(method = "DELETE", path = "coupon", hasBody = true)
    @Headers("Content-Type: application/json")
    fun deleteCoupon(@Header("deviceUUID") deviceUUID: String, @Body body: Any?): Call<Unit>

    @GET("stamp/map")
    @Headers("Content-Type: application/json")
    fun getStamp(@Header("deviceUUID") deviceUUID: String): Call<ArrayList<StampModel>>

    @POST("stamp")
    @Headers("Content-Type: application/json")
    fun postStamp(@Header("deviceUUID") deviceUUID: String, @Body body: Any?): Call<Unit>
}
