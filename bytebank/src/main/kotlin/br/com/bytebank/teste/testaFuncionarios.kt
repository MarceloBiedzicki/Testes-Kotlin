package br.com.bytebank.teste

import br.com.bytebank.modelo.Analista
import br.com.bytebank.modelo.CalculadoraBonificacao
import br.com.bytebank.modelo.Diretor
import br.com.bytebank.modelo.Gerente

fun testaFuncionarios() {
    val alex = Analista(
        nome = "Alex",               //funcionario
        cpf = "033.455.000-12",
        salario = 1000.0
    )

    println("nome ${alex.nome}")
    println("cpf ${alex.cpf}")
    println("salario ${alex.salario}")
    println("bonificação ${alex.bonificacao}")

    val fran = Gerente(
        nome = "fran",              //gerente
        senha = 1234,
        salario = 2000.0,
        cpf = "123.123.123-12"
    )

    println("bonificação de ${fran.nome} é de ${fran.bonificacao}")

    if (fran.autentica(1234)) {
        println("pode entrar")
    } else {
        println("num pode entrar")
    }

    val joao = Diretor(
        nome = "joao",
        cpf = "123.123.123-12",             //diretor
        salario = 4000.0,
        senha = 4000,
        plr = 200.0
    )

    println(
        """
        nome ${joao.nome}
        cpf ${joao.cpf}
        salario ${joao.salario}
        plr ${joao.plr}
        bonificação: ${joao.bonificacao}
    """.trimIndent()
    )

    if (joao.autentica(4000)) {
        println("autenticado")
    } else {
        print("não autenticado")
    }

    val calculadora = CalculadoraBonificacao()
    calculadora.registra(joao)   //diretor
    calculadora.registra(alex)   //funcionario
    calculadora.registra(fran)   //gerente

    println("a bonificação das 3 instancias é de ${calculadora.total} reais")

    val maria = Analista(
        nome = "Maria",             //analista
        cpf = "123.123.123-12",
        salario = 3000.0
    )

    calculadora.registra(maria)

    println("a nova bonificação total é ${calculadora.total}")
}