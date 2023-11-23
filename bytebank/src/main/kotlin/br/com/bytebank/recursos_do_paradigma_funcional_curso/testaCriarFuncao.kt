package br.com.bytebank.recursos_do_paradigma_funcional_curso

fun testaCriarFuncao() {
    val dividePor100 = criarFuncao(100.0)
    val resultado2 = dividePor100(2)

    println(resultado2)
}

fun criarFuncao(peso: Double) : (Int) -> Double {
    return {numInt -> numInt / peso}
}