package com.papered.gorae.model

import com.google.gson.annotations.SerializedName

data class StampModel (
    @SerializedName("is_captured")
    var isCaptured:Boolean,
    @SerializedName("location")
    var location:String,
    @SerializedName("name")
    var stampName:String,
    @SerializedName("x")
    var widthLocation:Int,
    @SerializedName("y")
    var heightLocation:Int
)