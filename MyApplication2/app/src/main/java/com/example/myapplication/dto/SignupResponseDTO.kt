package com.example.myapplication.dto

import com.google.gson.annotations.SerializedName

data class SignupResponseDTO (
    @SerializedName("pmsg")
    var msg: String
)