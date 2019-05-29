package com.papered.gorae.connector

import com.papered.gorae.model.CouponModel
import retrofit2.Call
import retrofit2.http.*

interface API {

    @GET("coupon")
    @Headers("Content-Type: application/json")
    fun getCoupon(@Header("deviceUUID") deviceUUID: String): Call<ArrayList<CouponModel>>

    @HTTP(method = "DELETE", path = "coupon", hasBody = true)
    @Headers("Content-Type: application/json")
    fun deleteCoupon(@Header("deviceUUID") deviceUUID: String, @Body body: Any?): Call<Unit>
}
