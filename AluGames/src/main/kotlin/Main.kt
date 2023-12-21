import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main(args: Array<String>) {

    val leitura = Scanner(System.`in`)
    println("Digite o código de jogo para buscar:")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()
    val infoJogo = gson.fromJson(json,InfoJogo::class.java)
    println(json)

    val jogo = Jogo(titulo = infoJogo.info.title, capa = infoJogo.info.thumb)

    println(jogo)

}