package br.com.bytebank.scopeFunctions

import br.com.bytebank.modelo.Endereco

fun testeWith(){

    with(Endereco()){
        rua = "rua vergueiro"
        numero = 3185
        cep = "3322334"
        bairro = "São Paulo"
        cidade= "São Paulo"
        toString()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}