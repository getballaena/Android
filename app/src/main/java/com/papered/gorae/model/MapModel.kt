package com.papered.gorae.model

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class MapModel(
    val endTimeTimestamp: Long,
    val map: ArrayList<MapListModel>,
    val myTeam: String
)

data class MapListModel(
    @SerializedName("booth_name")
    val boothName: String,
    @SerializedName("own_team")
    val ownTeam: String,
    val location: String,
    val x: Int,
    val y: Int
)