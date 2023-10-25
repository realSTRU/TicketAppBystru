package com.example.ticketapp.data.remote.api

import com.example.ticketapp.data.remote.dto.ClienteDto
import com.example.ticketapp.data.remote.dto.TicketDto
import com.example.ticketapp.util.Resource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ClienteApi {

    @GET("/api/Cliente")
    suspend fun getCliente():List<ClienteDto>

    @GET("/api/Cliente/{id}")
    suspend fun getClienteById(@Path("ClienteId") clienteId: Int) : Response<ClienteDto>

    @POST("/api/Cliente")
    suspend fun postCliente(@Body cliente: ClienteDto): Response<ClienteDto>

    @DELETE("/api/Cliente/{id}")
    suspend fun deleteCliente(@Path("ClienteId") clienteId: Int) : Response<ClienteDto>

}