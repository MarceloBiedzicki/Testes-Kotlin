package br.com.alura.arrays

import java.math.BigDecimal
import java.math.RoundingMode

fun calculaAumento(valor: BigDecimal, aumento: BigDecimal): BigDecimal =
    if (valor < "5000.00".toBigDecimal()) {
        valor + "500.00".toBigDecimal()
    } else {
        (valor * aumento)
            .setScale(2, RoundingMode.UP)
    }