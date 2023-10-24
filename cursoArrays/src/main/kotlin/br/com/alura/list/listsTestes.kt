package br.com.alura.list

fun listsTestes() {
    val livro1 = Livro(
        titulo = "Grande Sertão: Veredas",
        autor = "João Guimaraes Rosa",
        anoPublicacao = 1956
    )

    val livro2 = Livro(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A"
    )

    val livro3 = Livro(
        titulo = "Memórias Póstumar de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881
    )

    val livro4 = Livro(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "Editora B"
    )

    val livros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3, livro4)

    livros.add(
        Livro(
            titulo = "Sagarana",
            autor = "João Guimarães Rosa",
            anoPublicacao = 1946
        )
    )

    livros.imprimeComMarcadores()

    livros.remove(livro1) //remove a primeira instancia de livro

    livros.imprimeComMarcadores()

    livros.removeAt(3) //remove a 4a instancia da lista

    livros.imprimeComMarcadores()

    val listaLivrosOrdenada: List<Livro> = livros.sorted()
    listaLivrosOrdenada.imprimeComMarcadores()

    livros.sortedBy { it.autor }.imprimeComMarcadores()

//    listaDeLivros
//        .filter { it.autor == "João Guimarães Rosa" }
//        .sortedBy { it.anoPublicacao }
//        .imprimeComMarcadores()

//    listaDeLivros
//        .filter { it.autor.startsWith("J") }
//        .sortedBy { it.anoPublicacao }
//        .imprimeComMarcadores()

    listaDeLivros
        .filter { it.autor.startsWith("J") }
        .sortedBy { it.anoPublicacao }
        .map { it.titulo }.imprimeString()

    listaDeLivros
            .groupBy { it.editora ?: "Editora Desconhecida"}
            .forEach { (editora, livros) ->
                println("$editora: ${livros.joinToString { it.titulo }}")
            }
}

