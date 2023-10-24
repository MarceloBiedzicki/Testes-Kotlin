package br.com.bytebank.teste

import br.com.bytebank.modelo.Autenticavel
import br.com.bytebank.modelo.Conta
import br.com.bytebank.modelo.SistemaInterno

fun testaObjects() {
    val fran = object : Autenticavel {
        val nome: String = "Fran"
        val cpf: String = "111.111.111-11"
        val senha: Int = 1000

        override fun autentica(senha: Int) = this.senha == senha
    }

    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(fran, 1000)

    println("total de contas é ${Conta.total}")
}