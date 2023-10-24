package br.com.bytebank.teste

import br.com.bytebank.modelo.Endereco

fun testaEqualsEHashCode() {
    val endereco: Endereco = Endereco("rua2", 2, "00000.000.00", "bairro2", "qamac")
    val endereco2: Endereco = Endereco("rua2", 2, "00000.000.00", "bairro2", "qamac")


    println(endereco)
    println(endereco2)
    println()

    println(endereco == endereco2)
    println(endereco.hashCode())
    println(endereco.hashCode() == endereco2.hashCode())

    println(
        "${endereco.javaClass}@${
            Integer.toHexString(endereco.hashCode())
        }"
    )
}