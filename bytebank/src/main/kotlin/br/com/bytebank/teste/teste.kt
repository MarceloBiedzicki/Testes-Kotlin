package br.com.bytebank.teste

fun teste(valor: Any) {
    val numero: Int? = valor as? Int
    println(numero)
}