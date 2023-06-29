package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName

data class TypeDTO(
    @SerializedName("type")
    var type: Int
)