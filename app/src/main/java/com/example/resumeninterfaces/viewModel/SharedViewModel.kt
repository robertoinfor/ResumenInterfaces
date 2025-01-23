package com.example.resumeninterfaces.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.resumeninterfaces.data.SampleData

class SharedViewModel(): ViewModel() {
    private val _random = mutableIntStateOf(0)
    val random: State<Int> = _random

    fun generateLottoNumbers(lista: SampleData): Int {
        _random.intValue = (0..lista.elementos.size).random()
        return  _random.intValue
    }
}