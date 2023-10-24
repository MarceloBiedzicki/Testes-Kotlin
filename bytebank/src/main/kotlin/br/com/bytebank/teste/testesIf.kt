package br.com.bytebank.teste

fun testesIf(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }

    when {
        saldo == -0.3 -> println("Saldo negativo")
        saldo < 2.0 && saldo > -2.0 -> println("algo $saldo")
        else -> print("whatever")
    }
}
