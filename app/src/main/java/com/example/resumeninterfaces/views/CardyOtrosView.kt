package com.example.resumeninterfaces.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.resumeninterfaces.components.Alert
import com.example.resumeninterfaces.components.MainButton
import com.example.resumeninterfaces.components.MainIconButton
import com.example.resumeninterfaces.components.MainTextField
import com.example.resumeninterfaces.components.SpaceH
import com.example.resumeninterfaces.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardyOtrosView(navController: NavController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "App descuentos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),

        navigationIcon = {
            MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                navController.popBackStack()
            }
        }
        )
    }
        ){
        ContentHomeView(it)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MainTextField(value = "hola", onValueChange = {  }, label = "Precio")
        SpaceH()
        MainTextField(value = "adios", onValueChange = {  }, label = "Descuento %")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {

        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {

        }

        /*
        if (state.showAlert){
            Alert(title = "Alerta",
                message = "Escribe el precio y descuento",
                confirmText = "Aceptar",
                onConfirmClick = {
                    viewModel3.cancelarAlerta()
                    //viewModel2.onValue("false", "showAlert")
                }) { }
        }
         */

    }
}