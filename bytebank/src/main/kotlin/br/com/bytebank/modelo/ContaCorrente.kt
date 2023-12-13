package br.com.bytebank.modelo

class ContaCorrente(
    titular: Cliente,
    numero: Int,
    numOpcional: Int = 2   //se não digitar nada na hora de criar o numero sera 2
) : ContaTransferivel(
    titular = titular,
    numero = numero,
) {

    override fun saca(valor: Double): Boolean {
        val valorComTaxa = valor + 0.1
        if (this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa
            return true
        }
        return false
    }

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
    }

}