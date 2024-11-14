package com.example.resumeninterfaces.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.resumeninterfaces.components.ActionButton
import com.example.resumeninterfaces.components.MainButton
import com.example.resumeninterfaces.components.MainIconButton
import com.example.resumeninterfaces.components.TitleBar
import com.example.resumeninterfaces.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentHomeView(navController)

    }
}

@Composable
fun ContentHomeView(navController: NavController){
    val id = 5
    var opcional by remember {
        mutableStateOf(value = "")
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    ){
        TitleView(name = "HomeView")
        TextField(value = opcional, onValueChange = {opcional = it}, label = { Text(text="Opcional") } )
        MainButton(name = "Enviar", backColor = Color.Red, color = Color.White) {
            navController.navigate("Detail/${id}/?${opcional}")
        }
    }
}