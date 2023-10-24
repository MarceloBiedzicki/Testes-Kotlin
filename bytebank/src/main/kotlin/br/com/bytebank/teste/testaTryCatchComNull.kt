package br.com.bytebank.teste

fun testaTryCatchComNull() {
    val entrada: String = "1"

    val valorRecebido: Double? = try {
        entrada.toDouble()
    } catch (e: NumberFormatException) {
        println("Problema na conversão")
        e.printStackTrace()
        null
    }

    val valorComTaxa: Double? = if (valorRecebido != null) {
        valorRecebido + 0.1
    } else {
        null
    }

    val testeWhen: Double? = when {
        valorComTaxa != null -> {
            valorComTaxa - 10.0
        }

        else -> {
            null
        }
    }

    val testeEarlyReturn = funcaoTaxa(100.0)

    if (valorComTaxa != null) {
        println("valor recebido: $valorComTaxa")
    } else {
        println("valor invalido")
    }
}