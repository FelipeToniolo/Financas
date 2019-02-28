package com.felipetoniolo.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.felipetoniolo.financas.R
import com.felipetoniolo.financas.model.Tipo
import com.felipetoniolo.financas.model.Transacao
import com.felipetoniolo.financas.ui.ResumoView
import com.felipetoniolo.financas.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes: List<Transacao> = transacoesDeExemplo()

        configuraResumo(transacoes)

        configuraLista(transacoes)

        lista_transacoes_adiciona_receita
                .setOnClickListener {
                    val view : View = window.decorView

                    val viewCriada = LayoutInflater.from(this).inflate(R.layout.form_transacao,
                            view as ViewGroup,
                            false)

                    AlertDialog.Builder(this)
                            .setTitle(R.string.adiciona_receita)
                            .setView(viewCriada)
                            .show()
                }

        lista_transacoes_adiciona_despesa
                .setOnClickListener {
                    val view : View = window.decorView

                    val viewCriada = LayoutInflater.from(this).inflate(R.layout.form_transacao, view as ViewGroup, false)

                    AlertDialog.Builder(this)
                        .setView(viewCriada)
                        .setTitle(R.string.adiciona_despesa)
                        .show()
                }
    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view : View = window.decorView
        val resumoView = ResumoView(this, view,transacoes)
        resumoView.atualiza()
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo(): List<Transacao> {
        return listOf(Transacao(
                valor = BigDecimal(20.5),
                tipo = Tipo.DESPESA,
                data = Calendar.getInstance()),
                Transacao(valor = BigDecimal(100.0),
                        categoria = "Economia",
                        tipo = Tipo.RECEITA),
                Transacao(BigDecimal(7000.0),
                        tipo = Tipo.DESPESA),
                Transacao(BigDecimal(5000.0),
                        categoria = "Premio", tipo = Tipo.RECEITA))
    }
}