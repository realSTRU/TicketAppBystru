package com.example.ticketapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TicketDto(
    val ticketId : Int ,
    val clienteId : Int,
    val fecha: String ,
    val solicitadoPor : String,
    val asunto : String,
    val descripcion : String
)