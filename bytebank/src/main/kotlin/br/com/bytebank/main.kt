package br.com.bytebank

import br.com.bytebank.modelo.Endereco
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException


fun main() {

    var enderecoNull: Endereco? = Endereco(rua = "rua1")
//    val rua: String? = enderecoNull?.rua
//    println(enderecoNull?.rua?.length)


    enderecoNull?.let { enderecoRandom: Endereco ->
        println(enderecoRandom.rua)
    }
    enderecoNull?.let {
//        var lenghtBairro: Int = it.bairro?.length ?: throw IllegalStateException("Bairro não pode ser vazio")
//        var bairroLength: Int = it.bairro?.length ?: 0
//        var medidas: String = it.numero?.toString() ?: throw IllegalArgumentException("Tem que ter algo escrito")
    }

    teste("h")
}

fun teste(valor: Any) {
    val numero: Int? = valor as? Int
    println(numero)
}










