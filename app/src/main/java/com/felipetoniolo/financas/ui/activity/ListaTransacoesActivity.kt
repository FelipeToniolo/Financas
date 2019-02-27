package com.felipetoniolo.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felipetoniolo.financas.R
import com.felipetoniolo.financas.model.Tipo
import com.felipetoniolo.financas.model.Transacao
import com.felipetoniolo.financas.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Transacao(
                valor = BigDecimal(20.5),
                tipo = Tipo.DESPESA,
                data = Calendar.getInstance()),
                Transacao(valor = BigDecimal(100.0),
                        categoria = "Economia",
                        tipo = Tipo.RECEITA),
                Transacao(BigDecimal(200.0),
                        tipo = Tipo.DESPESA),
                Transacao(BigDecimal(500.0),
                        categoria= "Premio", tipo = Tipo.RECEITA))

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)

    }
}