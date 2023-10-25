package com.example.ticketapp.ui.cliente

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBusiness
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ClientRegisterScreen(
    viewModel: ClienteViewModel = hiltViewModel(),
    navController: NavController
)
{
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {Text(text = "Registro de clientes") },
                actions = {
                    IconButton(onClick = {viewModel.clean()})
                    {
                        Icon(
                            imageVector = Icons.Default.Refresh, contentDescription = "Limpiar"
                        )
                    }
                }
            )
        }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Form()
        }
    }



}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Form(
    viewModel: ClienteViewModel = hiltViewModel()
)
{
    val camposLlenos = !viewModel.nombres.isNullOrBlank() && !viewModel.direccion.isNullOrBlank() && !viewModel.rnc.isNullOrBlank() && !viewModel.limiteDeCredito.isNullOrBlank()
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 10.dp)
    ){
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
            ,modifier = Modifier
                .size(width = 350.dp, height = 500.dp),

            )
        {

            Column {
                val keyboardController = LocalSoftwareKeyboardController.current
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 10.dp),
                    label = { Text(text = "Nombres") },
                    singleLine = true,
                    maxLines = 1,
                    value = viewModel.nombres,
                    onValueChange = {viewModel.onNombresChanged(it)},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription ="Student Name"
                        )
                    },
                    isError =  viewModel.nombresError,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next)

                )
                if (viewModel.nombres.isBlank()) {
                    Text(text = "los nombres son requeridos",
                        fontSize = 8.sp,
                        color = Color.Red)
                }

                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 10.dp),
                    label = { Text(text ="rnc") },
                    singleLine = true,
                    maxLines = 1,
                    value = viewModel.rnc,
                    onValueChange = {viewModel.onRncChanged(it)},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.ListAlt,
                            contentDescription = "Rnc"
                        )
                    },
                    isError = viewModel.rncError,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next)

                )
                if (viewModel.rnc.isBlank()) {
                    Text(text = "rnc es requerido",
                        fontSize = 8.sp,
                        color = Color.Red)
                }
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 10.dp),
                    label = { Text(text = "Dirección") },
                    singleLine = true,
                    maxLines = 1,
                    value = viewModel.direccion,
                    onValueChange = {viewModel.onDireccionChanged(it)},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.AddBusiness,
                            contentDescription = "Direccion"
                        )
                    },
                    isError = viewModel.direccionError,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next)

                )
                if (viewModel.direccion.isBlank()) {
                    Text(text = "la direccion es requerida",
                        fontSize = 8.sp,
                        color = Color.Red)
                }

                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 10.dp),
                    label = { Text(text = "Limite de credito") },
                    singleLine = true,
                    maxLines = 1,
                    value = viewModel.limiteDeCredito,
                    onValueChange = {viewModel.onLimiteDeCreditoChanged(it)},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.AttachMoney,
                            contentDescription = "Credito"
                        )
                    },
                    isError = viewModel.limiteDeCreditoError,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next)

                )
                if (viewModel.limiteDeCredito.isBlank()) {
                    Text(text = "limite de credito requerido",
                        fontSize = 8.sp,
                        color = Color.Red)
                }
                Row (
                    horizontalArrangement = Arrangement.End, modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth())
                {
                    FloatingActionButton(
                        modifier = Modifier
                            .clickable(enabled =true){}
                        , onClick = {
                            if (camposLlenos) {
                                keyboardController?.hide()
                                viewModel.postBoleto()
                                showToast("Cliente guardado")
                            }
                        },){
                        Icon(imageVector = Icons.Default.SaveAs, contentDescription = "Add")
                    }
                }


            }

        }

    }
}