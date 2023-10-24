package br.com.bytebank.teste

fun testaLoopFor() {
    for (i in 7 downTo 1 step 2) {
        if (i < 4) {
            break
        }
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo: Double = 1.0 - i

        println("titular $titular")
        println("numero da conta $numeroConta")
        println("saldo da conta $saldo")
    }
}