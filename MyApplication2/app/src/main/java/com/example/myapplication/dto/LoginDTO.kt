package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("loginId")
    var loginId: String,
    @SerializedName("password")
    var password: String
)