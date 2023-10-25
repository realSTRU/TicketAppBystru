package com.example.ticketapp.ui.cliente

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ClienteScreen(
    viewModel : ClienteViewModel = hiltViewModel(),
    navController: NavController

)
{
    val clientes = viewModel.uiStateClientes.value



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Clientes", color = Color.White) },
            )
        },
        content = {
            Column {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp)
                ) {
                    items(clientes.clientes) { cliente ->
                        Surface(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            color = Color.DarkGray,
                            shadowElevation = 3.dp,
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Column {
                                Text(
                                    text = "id: ${cliente.clienteId}",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Nombres: ${cliente.nombres}",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "rnc: ${cliente.rnc}",
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "Direccion: ${cliente.direccion}",
                                    fontSize = 14.sp
                                )
                            }
                        }
                        Divider()
                    }
                }
            }
        }
    )



}

