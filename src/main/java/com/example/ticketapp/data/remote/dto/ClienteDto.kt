package com.example.ticketapp.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClienteDto(
    val clientId : Int,
    val nombres : String,
    val rnc : String,
    val direccion : String,
    val limiteCredito : Int,
)