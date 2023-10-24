package br.com.bytebank.teste

fun testaLacos() {
    var i = 0

    while (i < 5) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo: Double = 1.0 - i

        println("titular $titular")
        println("numero da conta $numeroConta")
        println("saldo da conta $saldo")
        i++
    }


    do {
        println("numero $i")
        i++
    } while (i <= 8)
}
