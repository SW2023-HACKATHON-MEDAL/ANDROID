package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName

data class SignupDTO(
    @SerializedName("loginId")
    var loginId: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("userName")
    var userName: String,
    @SerializedName("phoneNumber")
    var phoneNumber: String,
    @SerializedName("role")
    var role: String,
    @SerializedName("targetLoginId")
    var targetLoginId: String?
)