package br.com.bytebank.teste

import br.com.bytebank.exceptions.FalhaAutenticacaoException
import br.com.bytebank.exceptions.SaldoInsuficienteException
import br.com.bytebank.modelo.Cliente
import br.com.bytebank.modelo.ContaCorrente
import br.com.bytebank.modelo.ContaPoupanca
import br.com.bytebank.modelo.Endereco

fun testaComportamentosConta() {

    val endereco: Endereco = Endereco(
        rua = "rua1",
        numero = 123,
        bairro = "bairro x",
        cidade = "cidade"
    )

    val contaPadrao = ContaCorrente(
        Cliente(
            nome = "Joao",
            cpf = "123",
            senha = 123,
            endereco = endereco
        ),
        numero = 800
    )

    val conta = ContaCorrente(
        titular = Cliente(
            nome = "Marcelo",
            cpf = "123",
            senha = 123,
            endereco = Endereco()
        ),
        numero = 300,
        numOpcional = 2
    )
    conta.deposita(10.3)
    println(conta.titular)
    println(conta.numero)

    val conta2 = ContaPoupanca(
        numero = 400,
        titular = Cliente(
            nome = "Fran",
            cpf = "123",
            senha = 123,
            endereco = endereco
        )
    )


    conta2.deposita(9.1)

    conta.deposita(100.0)
    println("${conta.titular.nome} foi depositado 100 reais.")
    println("modelo.Conta  de ${conta.titular.nome} agora tem ${conta.saldo} reais.")

    println("Saldo atual de ${conta.saldo} reais na conta de ${conta.titular.nome}")
    println("Saldo atual de ${conta2.saldo} reais na conta de ${conta2.titular.nome}")

    try {
        conta.transfere(conta2, 10.0, 123)
        println("Transferencia realizada com sucesso!!!")
    } catch (e: SaldoInsuficienteException) {
        println("Saldo insuficiente para a transferencia")
        e.printStackTrace()
    } catch (e: FalhaAutenticacaoException) {
        println("Falha na autenticação")
        println("Falha na transferencia")
    } catch (e: Exception) {
        println("Erro desconhecido")
        e.printStackTrace()
    }


    print(
        """
        Apos a transferencia
        modelo.Conta ${conta.titular.nome} saldo de: ${conta.saldo}
        modelo.Conta ${conta2.titular.nome} saldo de: ${conta2.saldo}
    """.trimIndent()
    )

    println()
    println("testando transferencia de ${conta.titular.nome}")
    if (conta.saca(200000.0)) {
        println("Saque bem sucedido")
    } else {
        println("Saldo insuficiente")
    }

    val continha: ContaPoupanca = ContaPoupanca(
        titular = Cliente(
            nome = "",
            cpf = "",
            endereco = endereco,
            senha = 1
        ),
        numero = 1
    )
}
