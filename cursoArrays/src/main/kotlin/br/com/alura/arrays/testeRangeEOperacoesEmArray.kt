package br.com.alura.arrays

fun testeRangeEOperacoesEmArray() {
    val serie: IntRange = 1.rangeTo(10)
    for (s in serie) {
        print("$s ")
    }

    println()

    val numerosPares = 0..99 step 2 // 0 until(99)
    for (numeroPar in numerosPares) {
        print("$numeroPar ")
    }

    println()

    val numerosParesReverso = 100 downTo 0 step 2
    numerosParesReverso.forEach { print("$it ") }

    println()

    val intervalo = 1500.0..5000.0
    val salario = 4000.0
    if (salario in intervalo) {
        println("Esta dentro do intervalo")
    } else {
        println("Nao esta no intervalo")
    }

    println()

    val alfabeto = 'a'..'z'
    val letra = 'f'
    println(letra in alfabeto)

    println()

    val idades: IntArray = intArrayOf(10, 8, 43, 76, 54, 23)
    val maiorIdade = idades.max()
    print("Maior Idade: $maiorIdade \n")

    val menorIdade = idades.min()

    val media = idades.average()
    println("a média de do array de idades é %.0f anos".format(media))
    println()

    val todosMaiores = idades.all { it >= 18 }
    println("Todos maiores? $todosMaiores")

    val existeMaior = idades.any { it >= 18 }
    println("Algum aluno é maior de idade? $existeMaior")

    val maiores = idades.filter { it >= 18 }
    println("Maiores: ${maiores}")

    val busca = idades.find { it >= 18 }
    println("Busca: $busca")
}