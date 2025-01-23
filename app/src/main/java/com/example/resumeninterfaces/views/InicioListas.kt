package com.example.resumeninterfaces.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.resumeninterfaces.components.TitleBar
import com.example.resumeninterfaces.data.SampleData
import com.example.resumeninterfaces.viewModel.SharedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InicioListas(navController: NavController, viewController: SharedViewModel) {
    var numero by remember {
        mutableStateOf(0)
    }
    var color by remember {
        mutableIntStateOf(0)
    }
    Scaffold {
        TitleBar(name = "Lista")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = 5.dp)
        ) {
            Text(text = "Pelotas")
            SpacerH()
            LazyRow {
                items(SampleData.elementos.size) { index: Int ->
                    Circulo(color = SampleData.elementos.get(color))
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                Button(onClick = {
                    color = viewController.generateLottoNumbers(SampleData)
                    numero++
                }) {
                    Text(text = "aniadir")
                }
                Text(text = "Cantidad: $numero")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                Button(onClick = { navController.navigate("Home2") }) {
                }
            }
        }
    }
}



@Composable
fun SpacerH() {
    Spacer(modifier = Modifier.height(5.dp))
}

@Composable
fun Circulo(color: Color) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .background(color, CircleShape)
    )
}