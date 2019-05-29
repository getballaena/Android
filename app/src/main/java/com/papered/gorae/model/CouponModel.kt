package com.papered.gorae.model

import com.google.gson.annotations.SerializedName

data class CouponModel(
    @SerializedName("couponId")
    var couponId: String,
    @SerializedName("couponName")
    var couponName: String
)