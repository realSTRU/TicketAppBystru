package com.example.ticketapp.ui.HomeMenu

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ticketapp.Nav.AppScreens
import com.example.ticketapp.ui.cliente.ClienteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: ClienteViewModel = hiltViewModel(),
    navController: NavController
)
{
    var context = LocalContext.current

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    //showToast("Menu principal")
    Scaffold (
        topBar = { TopAppBar(title = { Text(text = "TicketApp Debug (Clientes)") },
            modifier = Modifier.shadow(8.dp),
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        )
        },
        content = ({
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 50.dp,start = 15.dp, end= 10.dp, bottom = 50.dp)
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                OutlinedButton(modifier = Modifier.fillMaxWidth()
                    .padding(top =150.dp),onClick = {
                    navController.navigate(route = AppScreens.ClientRegisterScreen.route)
                }) {
                    Icon(imageVector = Icons.Default.Accessibility, contentDescription ="Guardar" )
                    Text("Client Register")
                }

                Spacer(modifier = Modifier.height(15.dp))
                OutlinedButton(modifier = Modifier.fillMaxWidth(),onClick = {
                    navController.navigate(route = AppScreens.ClienteScreen.route)
                }) {
                    Icon(imageVector = Icons.Default.ListAlt, contentDescription ="Guardar" )
                    Text("Client consult")
                }

            }



        })
    )

}