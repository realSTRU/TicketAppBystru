package com.example.ticketapp.data.remote.dto

import com.squareup.moshi.Json

data class TicketDto(
    val ticketId : Int ,
    val clienteId : Int,
    val fecha: String ,
    val solicitadoPor : String,
    val asunto : String,
    val descripcion : String
)