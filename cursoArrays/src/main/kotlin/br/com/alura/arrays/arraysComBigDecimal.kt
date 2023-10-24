package br.com.alura.arrays

import java.math.BigDecimal
import java.math.RoundingMode

fun arraysComBigDecimal() {
    val valores: Array<BigDecimal> = bigDecimalArrayOf("1300.55", "2000.00", "5000.00", "7400.00")
    println(valores.contentToString())

    val aumento = "1.1".toBigDecimal()

    val valoresComAumento = valores
        .map { valor ->
            calculaAumento(valor, aumento)
        }.toTypedArray()


    println(valoresComAumento.contentToString())

    val soma: BigDecimal = valoresComAumento.somatoria() //somatoria é função criada

    println("a soma do array de valores é:$soma ")

    //proximo é exemplo de como usar fold

    val meses = 6.toBigDecimal()

    val valor6Meses = valoresComAumento.fold(soma) { acumulador, valor ->
        acumulador + (valor * meses).setScale(2, RoundingMode.UP)
    }

    println(valor6Meses)

    //pegar os 3 maiores valores e fazer uma média
    val mediaMaiores: Double = valoresComAumento
        .sortedDescending()
        .take(3)
        .reduce { acc, bigDecimal -> acc + bigDecimal }
        .divide(BigDecimal(3), RoundingMode.HALF_UP)
        .toDouble()

    println("A media dos 3 maiores valores é de: $mediaMaiores")

    //pegar os 3 menores valores para média
    val mediaMenores: Double = valoresComAumento
        .sorted()
        .take(3)
        .reduce { acc, bigDecimal -> acc + bigDecimal }
        .divide(BigDecimal(3),RoundingMode.HALF_UP)
        .toDouble()

    println("A média dos 3 menores valores é de: $mediaMenores")

}

