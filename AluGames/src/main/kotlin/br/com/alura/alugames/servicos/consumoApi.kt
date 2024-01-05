package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.*
import br.com.alura.alugames.utilitario.criaJogo
import br.com.alura.alugames.utilitario.toGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

private fun consomeDados(endereco: String): String {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    return response.body()
}

fun buscaJogo(id: String): Jogo? {
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

    val gson = Gson()

    val resultado = runCatching {
        val infoJogo = gson.fromJson(
            consomeDados(endereco),
            InfoJogo::class.java
        )

        Jogo(
            titulo = infoJogo.info.title,
            capa = infoJogo.info.thumb
        )
    }
    return resultado.onFailure {
        println("Erro tente outro id.")
    }.getOrNull()
}

fun buscaGamers(): List<Gamer> {
    val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

    val gson = Gson()

    val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
    val json = consomeDados(endereco)

//    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
    val listaGamer: List<InfoGamerJson> = gson
        .fromJson(json, meuGamerTipo)

    return listaGamer.map { it.toGamer() }
}

fun buscaJogosJson(): List<Jogo> {

    val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
    val json = consomeDados(endereco)

    val gson = Gson()
    val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type

    val listaJogos: List<InfoJogoJson> = gson
        .fromJson(json, meuJogoTipo)

    val listaJogoConvertida = listaJogos.map { infoJogoJson -> infoJogoJson.criaJogo() }

    return listaJogoConvertida
}

/**
 * https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json
 * https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json
 */

//try {
//    val infoJogo = gson.fromJson(json, InfoJogo::class.java)
//    return infoJogo
//} catch (ex: JsonSyntaxException) {
//    println("Erro ao tentar buscar jogo, tente outro id.")
//}
