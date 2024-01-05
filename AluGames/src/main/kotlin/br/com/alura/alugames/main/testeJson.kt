package br.com.alura.alugames.main

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.*
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main() {

    val listaGamers = buscaGamers()
    val listaJogos = buscaJogosJson()
//    println(listaGamers)
//    println(listaJogos)

    val gamerCaroline = listaGamers[3]

    val jogoResidentEvilVillage = listaJogos[10]
    val jogoSpider = listaJogos.get(13)
    val jogoLastOfUs = listaJogos.get(2)
    val jogoResidentVillage = listaJogos.get(10)
    val jogoTheLastOfUs = listaJogos.get(2)
    val jogoDandara = listaJogos.get(5)
    val jogoAssassins = listaJogos.get(4)
    val jogoCyber = listaJogos.get(6)
    val jogoGod = listaJogos.get(7)
    val jogoSkyrim = listaJogos.get(18)

    println(gamerCaroline)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline.alugaJogo(jogoResidentEvilVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoLastOfUs, periodo3)

    println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura(
        tipo = "PRATA",
        mensalidade = BigDecimal("9.90"),
        jogosIncluidos = 3,
        percentualDescontoReputacao = BigDecimal("0.15")
    )

    gamerCamila.alugaJogo(jogoResidentEvilVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpider, periodo2)
    gamerCamila.alugaJogo(jogoLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoResidentEvilVillage, periodo1)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)

    println(gamerCamila.jogosAlugados)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentEvilVillage, periodo1)
    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendarJogo(jogoResidentEvilVillage, 8)
    gamerCaroline.recomendarJogo(jogoResidentEvilVillage, 8)
    gamerCamila.recomendarJogo(jogoLastOfUs, 4)
    gamerCaroline.recomendarJogo(jogoLastOfUs, 9)

    println("Recomendações Camila")
    println(gamerCamila.jogosRecomendados)
    print("Recomendações Caroline")
    println(gamerCaroline.jogosRecomendados)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)

    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)

}