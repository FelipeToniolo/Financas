package com.felipetoniolo.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felipetoniolo.financas.R
import com.felipetoniolo.financas.model.Transacao
import com.felipetoniolo.financas.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Transacao(BigDecimal(20.5),
                "Comida", Calendar.getInstance()),
                Transacao(BigDecimal(100.0),"Economia", Calendar.getInstance()))

        lista_transacoes_listview.setAdapter(
                ListaTransacoesAdapter(transacoes, this))

    }
}