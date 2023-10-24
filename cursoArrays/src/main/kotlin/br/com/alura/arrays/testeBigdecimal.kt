package br.com.alura.arrays

import java.math.BigDecimal
import java.math.RoundingMode

fun testeBigDecimal() {
    val numero1 = BigDecimal("10.52222222220")
    val numero2 = BigDecimal("5.7345")

    val soma = numero1 + numero2
    val subtracao = numero1 - numero2
    val multiplicacao = numero1 * numero2
    val divisao = numero1 / numero2


    val numeroArredondado = divisao.setScale(2, RoundingMode.HALF_UP)
    println(numeroArredondado)
    println(divisao)
}