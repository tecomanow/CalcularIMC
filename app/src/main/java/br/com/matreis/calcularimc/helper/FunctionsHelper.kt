package br.com.matreis.calcularimc.helper

import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

val ptBr = Locale("pt", "BR")
val dateFormat = SimpleDateFormat("dd/MM/yyyy - HH:ss", ptBr)

fun TextInputEditText.getInputValue(): Double {
    return this.text.toString().toDouble()
}

fun Long.getDateFormatted(): String{
    return dateFormat.format(this)
}

fun Double.getBmiFormatted(): String {
    return String.format(ptBr,"%.2f", this)
}
