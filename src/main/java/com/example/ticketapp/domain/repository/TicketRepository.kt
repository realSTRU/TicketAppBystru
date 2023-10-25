package com.example.ticketapp.domain.repository

import com.example.ticketapp.data.remote.api.TicketApi
import com.example.ticketapp.data.remote.dto.TicketDto
import com.example.ticketapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import retrofit2.Response

class TicketRepository @Inject constructor(
    private val api: TicketApi
) {
    fun getTickets(): Flow<Resource<List<TicketDto>>> = flow {
        try {
            emit(Resource.Loading()) //indicar que estamos cargando

            val coins = api.getTicket() //descarga las monedas de internet, se supone quedemora algo

            emit(Resource.Success(coins)) //indicar que se cargo correctamente y pasarle las monedas
        } catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    suspend fun postTicket(ticket : TicketDto) : TicketDto?{
        return try {
            withContext(Dispatchers.IO) {
                val response = api.postTicket(ticket)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun deleteTicket(id : Int) : TicketDto?{
        return try {
            withContext(Dispatchers.IO) {
                val response = api.deleteTicket(id)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun getTicketById(id: Int) : Response<TicketDto>
    {
        try {
            return api.getTicketById(id)
        } catch (e: Exception) {
            throw e
        }
    }
}