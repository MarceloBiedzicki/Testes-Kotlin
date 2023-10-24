package br.com.bytebank.teste

import br.com.bytebank.modelo.Endereco

fun testaPilha(){

    println("inicio da função")
    funcao1()
    println("fim função")
}

fun funcao1() {
    println("início funcao1")
    try {
        funcao2()
    } catch (e: ClassCastException) {
        println("ClassCastException pega")
        e.printStackTrace()
    }

    println("fim funcao1")
}

fun funcao2() {
    println("início funcao2")
    for (i in 1..5) {
        println(i)
        val endereco = Any()
        endereco as Endereco

    }
    println("fim funcao2")
}
