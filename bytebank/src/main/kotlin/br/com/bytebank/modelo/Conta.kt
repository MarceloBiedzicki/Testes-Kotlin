package br.com.bytebank.modelo

abstract class Conta(
    val titular: Cliente,
    val numero: Int,
) : Autenticavel by titular{

    var saldo = 0.0
        protected set

    private var text: String? = null

    companion object {
        var total = 0
            private set
    }

    init {
        println("Conta de ${titular.nome} sendo criada")
        total++
    }

    constructor(
        titular: Cliente,
        numero: Int,
        text: String?
    ) : this(
        titular,
        numero
    ) {
        this.text = text
    }

    open fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double): Boolean

}


class ContaPoupanca(
    titular: Cliente,
    numero: Int,
) : ContaTransferivel(
    titular = titular,
    numero = numero,
) {

    override fun saca(valor: Double): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor
            return true
        }
        return false
    }


}

class ContaSalario(
    titular: Cliente, numero: Int
) : Conta(
    titular, numero
) {
    override fun saca(valor: Double): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor
            return true
        }
        return false
    }

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
    }
}