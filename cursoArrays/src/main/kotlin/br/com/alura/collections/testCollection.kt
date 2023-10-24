package br.com.alura.collections

fun testCollection(){

    val nomes: Collection<String> = mutableListOf(
            "Marco",
            "Nemesis",
            "Frombs",
            "Alatreon"
    )

    for (nome in nomes){
        println(nome)
    }

    println(nomes)
    println("Tem Nemesis na lista? ${nomes.contains("Frombs")}")
    println(nomes.size)
}
