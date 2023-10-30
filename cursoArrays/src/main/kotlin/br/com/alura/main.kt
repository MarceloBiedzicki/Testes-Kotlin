package br.com.alura

import br.com.alura.collections.comportamentos

fun main() {

    val pedidos = mapOf(Pair(1, 20.0), Pair(2, 34.0), 3 to 50.0) //usando o ifix pode ter perda de
    println(pedidos)                                                            //performance

    val pedido= pedidos[1] //nullable por não saber se tem a chave n° 0

    pedido?.let {
        println("pedido $it")
    }

    for (pedido: Map.Entry<Int, Double> in pedidos){
        println("Número do pedido: ${pedido.key}")
        println("Valor do pedido: ${pedido.value}")
    }

}






