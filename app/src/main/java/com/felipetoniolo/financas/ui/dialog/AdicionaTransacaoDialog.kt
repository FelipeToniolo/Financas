package com.felipetoniolo.financas.ui.dialog

import android.content.Context
import android.view.ViewGroup
import com.felipetoniolo.financas.R
import com.felipetoniolo.financas.model.Tipo

class AdicionaTransacaoDialog(
        viewGroup: ViewGroup,
        context: Context) : FormularioTransacaoDialog(context, viewGroup) {
    override val tituloBotaoPositivo: String
        get() = "Adiciona"

    override fun tituloPor(tipo: Tipo): Int {

        if (tipo == Tipo.RECEITA) {
            return R.string.adiciona_receita
        }
        return R.string.adiciona_despesa

    }
}