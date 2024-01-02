package br.com.alura.alugames.main

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.servicos.buscaJogo
import transformarEmIdade
import java.util.*

fun main(args: Array<String>) {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro Concluído com sucesso.\n Dados do gamer:")
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())
    var contador = 0

    do {
        println("Digite o código de jogo para buscar:")
        val busca = leitura.nextLine()

        val resultadoBusca = buscaJogo(busca)

        resultadoBusca?.let { jogo ->

            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", ignoreCase = true)) {
                println("Insira a descrição personalizada para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                jogo.descricao = descricaoPersonalizada
            } else {
                jogo.descricao = jogo.titulo
            }
            contador++
            jogo.numero = contador
            gamer.jogosBuscados.add(jogo)
        }

        println("Deseja buscar outro jogo S/N")
        val resposta = leitura.nextLine()

//        while (resposta.uppercase() == "S")
    } while (resposta.equals("s", true))

//    println("-------------------Exemplo sort----------------------")
//    gamer.jogosBuscados.sortBy { it.titulo }
//    gamer.jogosBuscados.forEach {
//        println("Titulo: ${it.titulo}")
//    }

    val listaFormatada = gamer.jogosBuscados.joinToString(
        separator = "\n",
        prefix = "* ",
        postfix = " *",
        transform = { jogo ->
            "\n-${jogo.numero}-\n Titulo: ${jogo.titulo} \n ${jogo.capa} \n Descrição:\n - ${jogo.descricao}..."
        }
    )

    println("-----------Jogos Buscados-------------")
    println(listaFormatada)

    println("-----------Jogos que iniciam de letra A a F ou S -----------")

//    val jogosFiltrados = gamer.jogosBuscados.filter {
//        it.titulo?.startsWith('S',true) ?: false
//    }

    gamer.jogosBuscados.filter {
        val primeiraLetra = it.titulo?.firstOrNull()?.uppercaseChar()
        primeiraLetra in setOf('A', 'B', 'C', 'D', 'E', 'F', 'S')
    }.let { lista ->
        lista.forEach { jogo ->
            println(jogo.titulo?.uppercase())
        }
    }

    println("Deseja excluir algum jogo da lista de Jogos Buscados? S/N")
    val opcao = leitura.nextLine()

    if (opcao.uppercase() == "S") {
        do {
            println("Qual numero do jogo que deseja remover?")
            var continua = true

            runCatching { leitura.nextInt() }.onSuccess {
                gamer.jogosBuscados.removeAt(it - 1)
            }.onFailure {
                println("Opção inválida, tente novamente.")
                continua = false
            }
            leitura.nextLine()
        } while (!continua)

    }
    println("------Lista Atualizada------")
    println(gamer.jogosBuscados)
    println("Busca realizada com sucesso!")


}
