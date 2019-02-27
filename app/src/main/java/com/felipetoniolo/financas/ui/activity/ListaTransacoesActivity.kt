package com.felipetoniolo.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felipetoniolo.financas.R
import com.felipetoniolo.financas.ui.adapter.TransactionsListAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*

class TransactionsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Trans)

        lista_transacoes_listview.setAdapter(TransactionsListAdapter(transacoes, this))

    }
}