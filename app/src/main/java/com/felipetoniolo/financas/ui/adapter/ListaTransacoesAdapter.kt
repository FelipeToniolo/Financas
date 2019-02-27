package com.felipetoniolo.financas.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.felipetoniolo.financas.R
import com.felipetoniolo.financas.extension.formataMoedaBrasileira
import com.felipetoniolo.financas.extension.formataParaBrasileiro
import com.felipetoniolo.financas.model.Tipo
import com.felipetoniolo.financas.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(transacoes: List<Transacao>,
                             context: Context) : BaseAdapter(){

    private val transacoes = transacoes
    private val context = context

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]

        if (transacao.tipo == Tipo.RECEITA){
            viewCriada.transacao_valor
                    .setTextColor(ContextCompat.getColor(context, R.color.receita))
        } else {
            viewCriada.transacao_valor
                    .setTextColor(ContextCompat.getColor(context, R.color.despesa))
        }

        if (transacao.tipo == Tipo.RECEITA) {
            viewCriada.transacao_icone
                    .setBackgroundResource(R.drawable.icone_transacao_item_receita)
        } else {
            viewCriada.transacao_icone
                    .setBackgroundResource((R.drawable.icone_transacao_item_despesa))
        }




        viewCriada.transacao_valor.text = transacao.valor.formataMoedaBrasileira()
        viewCriada.transacao_categoria.text = transacao.categoria
        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()

        return viewCriada
    }

    override fun getItem(posicao: Int): Transacao {
        return transacoes[posicao]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
    return transacoes.size

    }
}