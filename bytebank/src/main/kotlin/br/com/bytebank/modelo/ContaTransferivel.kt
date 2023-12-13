package br.com.bytebank.modelo

import br.com.bytebank.exceptions.SaldoInsuficienteException

abstract class ContaTransferivel(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {

    fun transfere(destino: Conta, valor: Double, senha: Int) {
        if (this.autentica(senha)) {
            if (this.saldo < valor) {
                throw SaldoInsuficienteException(
                    mensagem = """
                    |Não tem saldo
                    |Saldo disponivel: $saldo
                    |Valor da transferencia: $valor
                """.trimMargin()
                )
            }
            this.saldo -= valor
            destino.deposita(valor)
        }
    }

}