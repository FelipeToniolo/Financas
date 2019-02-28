package com.felipetoniolo.financas.ui

import android.view.View
import com.felipetoniolo.financas.extension.formataMoedaBrasileira
import com.felipetoniolo.financas.model.Resumo
import com.felipetoniolo.financas.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*

class ResumoView(private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)

    fun adicionaReceita() {
        val totalReceita = resumo.receita()
        view.resumo_card_receita.text = totalReceita
                .formataMoedaBrasileira()
    }
    fun adicionaDespesa (){
        val totalDespesa = resumo.despesa()
        view.resumo_card_despesa.text = totalDespesa.formataMoedaBrasileira()
    }

    fun adicionaTotal() {
        val total = resumo.total()
        view.resumo_card_total.text = total.formataMoedaBrasileira()
    }
}