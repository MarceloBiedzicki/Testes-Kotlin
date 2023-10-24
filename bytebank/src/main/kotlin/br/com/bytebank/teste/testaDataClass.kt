package br.com.bytebank.teste

import br.com.bytebank.modelo.Pessoa

fun testaDataClass() {
    val pessoa: Pessoa = Pessoa(
        nome = "vander",
        idade = 12
    )

    val pessoa2 = pessoa.copy()

    println(pessoa == pessoa2)
    println(pessoa === pessoa2)

    val (name, age) = pessoa

    println("nome: $name, idade: $age")
}