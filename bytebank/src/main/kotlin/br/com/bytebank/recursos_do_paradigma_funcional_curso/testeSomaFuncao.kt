package br.com.bytebank.recursos_do_paradigma_funcional_curso


fun testeSomaFuncao() {

    val soma: (Int, Int) -> Int = { a, b -> a + b }

    val resultado = soma(1, 2)

    println(resultado)
}