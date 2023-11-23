package br.com.bytebank.recursos_do_paradigma_funcional_curso


fun testaTipoFuncaoClasse() {


    val minhaFuncaoClasses = Teste()        //não precisa tipar o : () -> Unit
    println(minhaFuncaoClasses())

    val lista = listOf(1, 2, 3, 4, 5, 6)
    val funcaoParaForEach: (Int) -> Boolean = { num ->
        num > 3
    }
    lista.forEach() { num ->
        println(funcaoParaForEach(num))
    }

    lista.forEach(::println)

    println("teste 2")
    val teste2 = Teste2()
    lista.forEach {
        println(teste2(it))
    }


}

class Teste : () -> Unit {
    override fun invoke() {
        println("executa invoke do teste")
    }
}

class Teste2 : (Int) -> Boolean {
    override fun invoke(p1: Int): Boolean {
        return p1 < 5
    }

}
