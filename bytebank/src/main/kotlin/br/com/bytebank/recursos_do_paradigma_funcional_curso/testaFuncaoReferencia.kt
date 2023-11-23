package br.com.bytebank.recursos_do_paradigma_funcional_curso

fun testaFuncaoReferencia() {
    val minhaFuncao: () -> Unit = { teste() }

    val minhaFuncao2: () -> Unit = ::teste

    minhaFuncao()
    minhaFuncao2()

    val testaSomaPorRef: (Int, Int) -> Int = :: soma
    println(testaSomaPorRef(5,7))

    val classeTestaSoma = TesteSoma()
    println(classeTestaSoma(2,2))

}

fun soma(a: Int, b: Int) : Int{
    return a + b
}

fun teste(){
    println("Executa teste")
}

class TesteSoma : (Int,Int)-> Int {
    override fun invoke(p1: Int, p2: Int): Int = p1 + p2
}
