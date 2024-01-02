package br.com.alura.alugames.main

import br.com.alura.alugames.modelo.Gamer

fun main(){

    val gamer1 = Gamer("Jack","jacktekken7@email.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Jen",
        "jen@email.com",
        "01/01/1990",
        "jenGamer"
    )
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "jacqueskywalker"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "outro nome"
    println(gamer1.idInterno)

}