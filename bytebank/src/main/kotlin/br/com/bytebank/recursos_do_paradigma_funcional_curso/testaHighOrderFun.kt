package br.com.bytebank.recursos_do_paradigma_funcional_curso

import br.com.bytebank.modelo.Endereco

fun testaHighOrderFun() {

    val testeFuncao: () -> Unit

    Endereco().let {
        it
    }

    "".let {::testeRecebeString
        it
    }

    1.let {
        it
    }

    teste (1){
        println(it)
    }

}

fun testeRecebeString(valor: String){
}
fun teste(valor: Int, bloco: (salario: Double) -> Unit): Unit {
    bloco(valor.toDouble())
}