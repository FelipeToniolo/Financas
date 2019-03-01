package com.felipetoniolo.financas.ui.activity

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.felipetoniolo.financas.R
import com.felipetoniolo.financas.delegate.TransacaoDelegate
import com.felipetoniolo.financas.extension.formataParaBrasileiro
import com.felipetoniolo.financas.model.Tipo
import com.felipetoniolo.financas.model.Transacao
import com.felipetoniolo.financas.ui.ResumoView
import com.felipetoniolo.financas.ui.adapter.ListaTransacoesAdapter
import com.felipetoniolo.financas.ui.dialog.AdicionaTransacaoDialog
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    private val transacoes: MutableList<Transacao> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        configuraResumo()

        configuraLista()

        lista_transacoes_adiciona_receita
                .setOnClickListener {
                    AdicionaTransacaoDialog(window.decorView as ViewGroup, this)
                            .configuraDialog(object : TransacaoDelegate {
                                override fun delegate(transacao: Transacao) {
                                    atualizaTransacoes(transacao)
                                    lista_transacoes_adiciona_menu.close(true)
                                }

                            })
                }

        lista_transacoes_adiciona_despesa
                .setOnClickListener {
                    val view: View = window.decorView

                    val viewCriada = LayoutInflater.from(this).inflate(R.layout.form_transacao,
                            view as ViewGroup,
                            false)

                    val ano1 = 2019

                    val mes1 = 2

                    var dia1 = 1

                    val hoje = Calendar.getInstance()
                    viewCriada.form_transacao_data
                            .setText(hoje.formataParaBrasileiro())
                    viewCriada.form_transacao_data
                            .setOnClickListener {
                                DatePickerDialog(this,
                                        DatePickerDialog.OnDateSetListener { view, ano, mes, dia ->
                                            val dataSelecionada = Calendar.getInstance()
                                            dataSelecionada.set(ano, mes, dia)
                                            viewCriada.form_transacao_data
                                                    .setText(dataSelecionada.formataParaBrasileiro())
                                        }
                                        , ano1, mes1, dia1)
                                        .show()

                            }

                    val adapterDespesa = ArrayAdapter
                            .createFromResource(this,
                                    R.array.categorias_de_despesa,
                                    android.R.layout.simple_spinner_dropdown_item)

                    viewCriada.form_transacao_categoria.adapter = adapterDespesa
                    AlertDialog.Builder(this)
                            .setView(viewCriada)
                            .setPositiveButton("Adicionar", DialogInterface.OnClickListener { dialogInterface, i ->
                                val valorEmTexto = viewCriada
                                        .form_transacao_valor.text.toString()
                                val dataEmTexto = viewCriada
                                        .form_transacao_data.text.toString()
                                val categoriaEmTexto = viewCriada
                                        .form_transacao_categoria.selectedItem.toString()

                                val valor = try {
                                    BigDecimal(valorEmTexto)
                                } catch (exception: NumberFormatException) {
                                    Toast.makeText(this, "Falha na conversão de valor", Toast.LENGTH_LONG)
                                            .show()
                                    BigDecimal.ZERO
                                }

                                val formatoBrasileiro = SimpleDateFormat("dd/MM/yyyy")
                                val dataConvertida = formatoBrasileiro.parse(dataEmTexto)
                                val data = Calendar.getInstance()
                                data.time = dataConvertida

                                val transacaoCriada = Transacao(tipo = Tipo.DESPESA,
                                        valor = valor,
                                        data = data,
                                        categoria = categoriaEmTexto)

                            })
                            .setNegativeButton("Cancelar", null)
                            .setTitle(R.string.adiciona_despesa)
                            .show()
                }
    }

    private fun atualizaTransacoes(transacao: Transacao) {
        transacoes.add(transacao)
        configuraLista()
        configuraResumo()
    }

    private fun configuraResumo() {
        val view: View = window.decorView
        val resumoView = ResumoView(this, view, transacoes)
        resumoView.atualiza()
    }

    private fun configuraLista() {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }


}