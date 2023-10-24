package br.com.alura.list

fun testPrateleira(){

    val prateleira = Prateleira(genero = "Literatura", livros = listaDeLivros)

    val porAutor = prateleira.organizarPorAutor()
    val porAnoDePublicacao = prateleira.organizaPorAnoDePublicacao()

}