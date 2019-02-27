package com.felipetoniolo.financas.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale
import java.util.*

fun BigDecimal.formataMoedaBrasileira() : String {
    val moeda = DecimalFormat
            .getCurrencyInstance(Locale("pt", "br"))
    val moedaBrasileiraFormatada = moeda
            .format(this)
            .replace("R$", "R$ ")
    return moedaBrasileiraFormatada
}