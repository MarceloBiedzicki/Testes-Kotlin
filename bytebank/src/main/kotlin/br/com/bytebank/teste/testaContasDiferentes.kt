package br.com.bytebank.teste

import br.com.bytebank.modelo.Cliente
import br.com.bytebank.modelo.ContaCorrente
import br.com.bytebank.modelo.ContaPoupanca
import br.com.bytebank.modelo.Endereco

fun testaContasDiferentes() {
    println("Hello world! ")

    val endereco: Endereco = Endereco(
        rua = "rua1",
        numero = 123,
        bairro = "bairro x",
        cidade = "cidade"
    )

    val contaCorrente = ContaCorrente(
        Cliente(
            "Jair",
            "123",
            endereco,
            12
        ), 1234
    )

    val contaPoupanca = ContaPoupanca(
        titular = Cliente(
            nome = "Maria",
            cpf = "123",
            senha = 12,
            endereco = endereco
        ),
        numero = 4321
    )

    contaPoupanca.deposita(1000.0)
    contaCorrente.deposita((1000.0))

    contaCorrente.saca(100.0)
    contaPoupanca.saca(100.0)

    println(
        """
        conta corrente saldo = ${contaCorrente.saldo}
        conta poupanca saldo = ${contaPoupanca.saldo}
    """.trimIndent()
    )

    contaCorrente.transfere(destino = contaPoupanca, valor = 100.0, 12)

    println(
        """
        conta corrente saldo = ${contaCorrente.saldo}
        conta poupanca saldo = ${contaPoupanca.saldo}
    """.trimIndent()
    )

    contaCorrente.transfere(contaPoupanca, 100.0, 12)

    println(
        """
        transferencia de corrente para poupança
        conta corrente saldo = ${contaCorrente.saldo}
        conta poupanca saldo = ${contaPoupanca.saldo}
    """.trimIndent()
    )

    contaPoupanca.transfere(contaCorrente, 100.0, 12)

    println(
        """
        transferencia de poupança para correntew
        conta corrente saldo = ${contaCorrente.saldo}
        conta poupanca saldo = ${contaPoupanca.saldo}
    """.trimIndent()
    )


}
