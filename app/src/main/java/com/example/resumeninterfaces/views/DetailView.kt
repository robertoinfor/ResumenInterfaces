package com.example.resumeninterfaces.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.resumeninterfaces.components.MainIconButton
import com.example.resumeninterfaces.components.TitleBar
import com.example.resumeninterfaces.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, id: Int, opcional: String){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Detail View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDetailView(navController, id, opcional)
    }
}

@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional: String){
    Column (modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    ) {
        TitleView(name = "DetailView")
        TitleView(name = id.toString())
        TitleView(name = opcional)
        Button(onClick = { navController.navigate("Otros") }) { }
    }
}