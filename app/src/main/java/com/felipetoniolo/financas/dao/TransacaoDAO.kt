package com.felipetoniolo.financas.dao

import com.felipetoniolo.financas.model.Transacao

class TransacaoDAO {
    val transacoes = Companion.transacoes

    companion object {
       private val transacoes : MutableList <Transacao> = mutableListOf()

    }

    fun adiciona ( transacao : Transacao){
        Companion.transacoes.add(transacao)

    }

    fun altera ( transacao: Transacao, posicao: Int ){
        Companion.transacoes[posicao] = transacao
    }

    fun remove ( posicao: Int){
        Companion.transacoes.removeAt(posicao)
    }
}