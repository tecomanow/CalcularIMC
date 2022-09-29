package br.com.matreis.calcularimc.presentation.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _bmi = MutableLiveData<Double>()
    private val _bmiDetail = MutableLiveData<String>()
    val bmi: LiveData<Double>
        get() = _bmi
    val bmiDetail: LiveData<String>
        get() = _bmiDetail

    fun calculateBMI(weight: Double, height: Double){

        val bmiResult = (weight) / (height * height)
        _bmiDetail.value = getBmiDetail(bmiResult)
        _bmi.value = bmiResult

    }

    fun getBmiDetail(bmi: Double): String {
        return if(bmi < 18.5){
            "Abaixo do peso"
        }else if(bmi < 24.9){
            "Peso Ideal"
        }else if(bmi < 29.9){
            "Levemente acima do peso"
        }else if(bmi < 34.9){
            "Obesidade grau I"
        }else if(bmi < 39.9){
            "Obesidade grau II"
        }else{
            "Obesidade grau III"
        }
    }

}