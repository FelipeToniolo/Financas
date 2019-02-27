package com.felipetoniolo.financas.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiro() : String{
    val formatoBrasileiro = "dd/MM/yyyy"
    val formatoPadrao = SimpleDateFormat(formatoBrasileiro)
    return formatoPadrao.format(this.time)

}