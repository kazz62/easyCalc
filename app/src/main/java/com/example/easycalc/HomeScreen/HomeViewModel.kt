package com.example.easycalc.HomeScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.easycalc.repository.EasyCalcRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: EasyCalcRepository
) : ViewModel() {
    var isSearching = mutableStateOf(false)
}