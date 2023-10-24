package br.com.alura.list

fun List<Livro?>.imprimeComMarcadores() {
    val textoFormatado = this
            .filterNotNull()  // ou  .filter { it != null }
            .joinToString(separator = "\n") {
        " - ${it.titulo} de ${it.autor}"
    }
    println(" ##### Lista  de Livros #### \n$textoFormatado")

}

fun List<String>.imprimeString() {
    val textoFormatado = this.joinToString(separator = "\n") {
        "-> $it."
    }
    println(" - - Resultado da pesquisa: \n$textoFormatado")
}