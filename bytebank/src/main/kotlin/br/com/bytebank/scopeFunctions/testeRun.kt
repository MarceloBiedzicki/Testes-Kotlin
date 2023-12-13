package br.com.bytebank.scopeFunctions

import br.com.bytebank.modelo.Cliente
import br.com.bytebank.modelo.ContaPoupanca


fun testeRun() {

    val taxaAnual = 0.05
    val taxaMensal: Double = taxaAnual / 12
    println("taxa mensal $taxaMensal")

    val contaPoupanca = ContaPoupanca(
        titular = Cliente(
            nome = "Alex",
            cpf = "111.111.111-11",
            senha = 1234
        ), numero = 1000
    )

    contaPoupanca.run {
        deposita(10000.0)
        saldo * taxaMensal
    }.let { rendimentoMensal ->
        println(rendimentoMensal)
    }
    var saldo = contaPoupanca.saldo
    val rendimentoAnual = run {
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }

    println("O rendimento anual é : %.2f".format(rendimentoAnual))

}