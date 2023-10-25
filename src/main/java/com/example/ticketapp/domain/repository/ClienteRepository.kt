package com.example.ticketapp.domain.repository

import com.example.ticketapp.data.remote.api.ClienteApi
import com.example.ticketapp.data.remote.api.TicketApi
import com.example.ticketapp.data.remote.dto.ClienteDto
import com.example.ticketapp.data.remote.dto.TicketDto
import com.example.ticketapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class ClienteRepository @Inject constructor(
    private val api: ClienteApi
) {
    fun getCoins(): Flow<Resource<List<ClienteDto>>> = flow {
        try {
            emit(Resource.Loading()) //indicar que estamos cargando

            val coins = api.getCliente() //descarga las monedas de internet, se supone quedemora algo

            emit(Resource.Success(coins)) //indicar que se cargo correctamente y pasarle las monedas
        } catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    suspend fun postCliente(cliente : ClienteDto) : ClienteDto?{
        return try {
            withContext(Dispatchers.IO) {
                val response = api.postCliente(cliente)
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

    suspend fun deleteCliente(id : Int) : ClienteDto?{
        return try {
            withContext(Dispatchers.IO) {
                val response = api.deleteCliente(id)
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

    suspend fun getClienteById(id: Int) : Response<ClienteDto>
    {
        try {
            return api.getClienteById(id)
        } catch (e: Exception) {
            throw e
        }
    }
}