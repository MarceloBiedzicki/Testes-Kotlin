package br.com.bytebank.teste

import br.com.bytebank.modelo.Endereco

fun testaLet() {
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