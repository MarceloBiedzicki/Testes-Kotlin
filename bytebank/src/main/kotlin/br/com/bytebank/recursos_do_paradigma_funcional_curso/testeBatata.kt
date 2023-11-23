package br.com.bytebank.recursos_do_paradigma_funcional_curso

typealias FuncaoBatata = () -> Unit

fun testeBatata() {

    val lista = listOf(1, 2, 3, 4, 5)

    val batata1: FuncaoBatata = {

        lista.forEach(action = ::testeLista)

    }

    testeBatata(batata1)

    testeBatata {
        lista.map(::testeIntToDouble)
            .forEach(::println)
    }


}

fun testeIntToDouble(p1: Int): Double {
    return p1 * 1.325
}

fun testeLista(a: Int) {
    println(a)
}

fun testeBatata(p1: FuncaoBatata) {

    p1.invoke()
    p1()

}
