package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName

data class LoginResponseDTO(
    @SerializedName("role")
    var role: String
)