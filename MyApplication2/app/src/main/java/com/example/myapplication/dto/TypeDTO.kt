package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName

data class TypeDTO(
    @SerializedName("password")
    var type: Int
)