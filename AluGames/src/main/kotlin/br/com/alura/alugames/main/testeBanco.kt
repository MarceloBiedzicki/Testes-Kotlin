package br.com.alura.alugames.main

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.JogoEntity
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Jogo
import java.math.BigDecimal
import javax.persistence.Table

fun main() {

    val jogo = Jogo(
        titulo = "The Last of Us Part I",
        capa = "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        preco = BigDecimal("5.99"),
        descricao = "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val jogo2 = Jogo(
        "Dandara",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",
        BigDecimal("9.99"),
        "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla " +
                "a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania."
    )
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
//    jogoDAO.adicionar(jogo2)

//    val jogoRecuperado = jogoDAO.recuperarPeloId(5)
//    println(jogoRecuperado)

//    jogoDAO.apagar(5)


    val listaJogos: List<Jogo> = jogoDAO.getLista()
    println(listaJogos)

    manager.close()

}

/*
    val annotations = JogoEntity::class.annotations
    annotations.forEach {
        println(it)
        if (it is Table){
            print("TableName = ${it.name}")
        }
    }
 */
