package com.felipetoniolo.financas.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formataMoedaBrasileira() : String {
    val moeda = DecimalFormat
            .getCurrencyInstance(Locale("pt", "br"))
    return moeda
            .format(this)
            .replace("R$", "R$ ")
            .replace("-R$ ","R$ -")

}