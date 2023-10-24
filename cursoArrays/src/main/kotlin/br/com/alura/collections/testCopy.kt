package br.com.alura.collections

fun testCopy() {
    val banco = BancoDeNomes()
    val nomesSalvos: Collection<String> = banco.nomes
    banco.salva("jose")
    println(banco.nomes)
    println(nomesSalvos)
}