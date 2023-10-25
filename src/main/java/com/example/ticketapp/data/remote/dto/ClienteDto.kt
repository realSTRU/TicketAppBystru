package com.example.ticketapp.data.remote.dto

data class ClienteDto(
    val clientId : Int,
    val nombres : String,
    val rnc : String,
    val direccion : String,
    val limiteCredito : Int,
)