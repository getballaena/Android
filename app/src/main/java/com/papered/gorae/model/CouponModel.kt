package com.papered.gorae.model

import com.google.gson.annotations.SerializedName

data class CouponModel(
    @SerializedName("coupon_id")
    var couponId: String,
    @SerializedName("coupon_name")
    var couponName: String
)