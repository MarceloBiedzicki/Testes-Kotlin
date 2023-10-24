package br.com.alura.arrays



fun testeArray() {
    val idade1: Int = 23
    val idade2: Int = 30
    val idade3: Int = 26

    val maiorIdadeIf = if (idade1 > idade2 && idade1 > idade3) {
        idade1
    } else if (idade2 > idade3) {
        idade2
    } else {
        idade3
    }

    println(maiorIdadeIf)

    val idades: IntArray = intArrayOf(25, 19, 33, 20, 55)

    var maiorIdade: Int = Int.MIN_VALUE
    for (idade in idades) {
        if (idade > maiorIdade) {
            maiorIdade = idade
        }
    }

    println(maiorIdade)

    //fazer uma media somente com as ultimas 3 maiores idades
    val media = idades.sortedArray().take(3).average()

    println("a media das 3 maiores idades é de: %.0f".format(media))

    var menorIdade = Int.MAX_VALUE

    idades.forEach { idade ->
        if (idade < menorIdade) {
            menorIdade = idade
        }
    }

    println(menorIdade)

    val salarios: DoubleArray = doubleArrayOf(1500.50, 2300.0, 5000.0, 8000.0, 10000.0)

    val aumento: Double = 1.1

//    for (indice in salarios.indices){
//        salarios[indice] = salarios[indice] * aumento
//    }
//
//    println(salarios.contentToString())

    salarios.forEachIndexed { i, salario ->
        salarios[i] = salario * aumento
    }
    println(salarios.contentToString())

}

