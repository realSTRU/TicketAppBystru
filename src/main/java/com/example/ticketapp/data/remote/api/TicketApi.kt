package com.example.ticketapp.data.remote.api

import com.example.ticketapp.data.remote.dto.TicketDto
import com.example.ticketapp.util.Resource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
interface TicketApi {

    @GET("/api/Ticket")
    suspend fun getTicket():List<TicketDto>

    @GET("/api/Ticket/{id}")
    suspend fun getTicketById(@Path("TicketId") ticketId: Int) : Resource<TicketDto>

    @POST("/api/Ticket")
    suspend fun postTicket(@Body ticket: TicketDto): Resource<TicketDto>

    @DELETE("/api/Ticket/{id}")
    suspend fun deleteTicket(@Path("TicketId") ticketId: Int) : Resource<TicketDto>

}