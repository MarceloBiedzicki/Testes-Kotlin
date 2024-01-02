package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.InfoGamerJson
import br.com.alura.alugames.modelo.InfoJogo
import br.com.alura.alugames.modelo.Jogo
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Paths

fun buscaJogo(id: String): Jogo? {
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()

    val resultado = runCatching {
        val infoJogo = gson.fromJson(json, InfoJogo::class.java)
        Jogo(
            titulo = infoJogo.info.title,
            capa = infoJogo.info.thumb
        )
    }
    return resultado.onFailure {
        println("Erro tente outro id.")
    }.getOrNull()
}

fun buscaGamers(): List<InfoGamerJson> {
    val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    val json = response.body()

    val gson = Gson()

    val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
    val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

    return listaGamer
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
