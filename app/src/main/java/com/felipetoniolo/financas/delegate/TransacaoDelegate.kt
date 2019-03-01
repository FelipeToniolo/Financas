package com.felipetoniolo.financas.delegate

import com.felipetoniolo.financas.model.Transacao

interface TransacaoDelegate {

    fun delegate(transacao: Transacao)
}