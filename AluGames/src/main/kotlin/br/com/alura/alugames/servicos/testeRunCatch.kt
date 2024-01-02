package br.com.alura.alugames.servicos

fun testeRunCatch() {

    //serve para executar uma linha de codigo e guardar o resultado,sendo excessão ou não
    val resultado = runCatching {
        val numero = 10 / 0
    }

    if (resultado.isSuccess) {
        println("Deu bom")
    } else {
        println("Não deu bom")
    }

    resultado.onSuccess {
        println("Muito bom")
    }

    resultado.onFailure {
        println("Not hehe")
    }
}