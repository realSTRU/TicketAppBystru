package com.example.ticketapp.ui.cliente

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketapp.data.remote.dto.ClienteDto
import com.example.ticketapp.domain.repository.ClienteRepository
import com.example.ticketapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


data class clienteListUiState(
    val isLoading: Boolean = false,
    val clientes : List<ClienteDto> = emptyList(),
    val error: String = ""

)
@HiltViewModel
class ClienteViewModel @Inject constructor(
    val repository: ClienteRepository
) : ViewModel() {
    private val _uiStateClientes = mutableStateOf(clienteListUiState())
    val uiStateClientes : State<clienteListUiState> = _uiStateClientes

    var nombres by mutableStateOf("")
    var rnc by mutableStateOf("")
    var direccion by mutableStateOf("")
    var limiteDeCredito by mutableStateOf("")

    var nombresError by mutableStateOf(true)
    var rncError by mutableStateOf(true)
    var direccionError by mutableStateOf(true)
    var limiteDeCreditoError by mutableStateOf(true)

    fun onNombresChanged(value: String)
    {
        nombresError = nombres.isNullOrBlank()
        nombres = value
    }
    fun onRncChanged(value: String)
    {
        rncError = rnc.isNullOrBlank()
        rnc = value
    }
    fun onDireccionChanged(value: String)
    {
        direccionError = direccion.isNullOrBlank()
        direccion = value
    }
    fun onLimiteDeCreditoChanged(value: String)
    {
        limiteDeCreditoError = limiteDeCredito.isNullOrBlank()
        limiteDeCredito = value
    }

    init {
        repository.getClientes().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _uiStateClientes.value = clienteListUiState(isLoading = true)
                }

                is Resource.Success -> {
                    _uiStateClientes.value =
                        clienteListUiState(clientes = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _uiStateClientes.value =
                        clienteListUiState(error = result.message ?: "Error desconocido")
                }
            }
        }.launchIn(viewModelScope)
    }
    fun validate() : Boolean
    {
        return !nombresError && !limiteDeCreditoError && !direccionError && !rncError
    }

    fun clean()
    {
        nombres = ""
        direccion = ""
        limiteDeCredito = ""
        rnc = ""

    }
    fun postBoleto() {
        try {
            if(validate())
            {
                viewModelScope.launch {
                    val cliente = ClienteDto(
                        clienteId = 0,
                        nombres = nombres,
                        limiteCredito = limiteDeCredito.toInt(),
                        direccion = direccion,
                        rnc = rnc
                    )
                    repository.postCliente(cliente)
                    clean()
                }
            }

        } catch (e: Exception) {

        }
    }

}