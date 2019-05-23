package com.papered.gorae.connector

import com.papered.gorae.model.CouponModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface API {

    @GET("coupon")
    @Headers("Content-Type: application/json")
    fun getCoupon(@Header("deviceUUID") deviceUUID: String): Call<ArrayList<CouponModel>>
}
