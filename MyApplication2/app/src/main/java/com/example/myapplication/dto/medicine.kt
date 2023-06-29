package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class medicine (
    @SerializedName("name")
    var name: String?,
    @SerializedName("color")
    var color:String?,
    @SerializedName("shape")
    var shape:String?,
    @SerializedName("texture")
    var texture:String?,
    @SerializedName("storeImgName")
    var storeImgName:String?,
    @SerializedName("alarmId")
    var alarmId:Long?
)