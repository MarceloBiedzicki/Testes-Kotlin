package br.com.alura.collections

fun testaMap() {
    val pedidos: MutableMap<Int, Double> = mutableMapOf(
            (Pair(1, 20.0)),
            (Pair(2, 34.0)),  //usando o ifix pode ter perda de
            3 to 50.0)        //performance

    println(pedidos)

    val lista: Map<String, String> = mapOf((Pair("primeiro", "batata")))

    println(lista["primeiro"])

    val pedido = pedidos[1] //nullable por não saber se tem a chave n° 0

    pedido?.let {
        println("pedido $it")
    }

    for (p: Map.Entry<Int, Double> in pedidos) {
        println("Número do pedido: ${p.key}")
        println("Valor do pedido: ${p.value}")
    }

    pedidos.put(5, 80.0)
    pedidos[1] = 21.0
    pedidos.putIfAbsent(6, 200.0)
    pedidos.putIfAbsent(6, 300.0)
    println(pedidos)
    pedidos.remove(6)

    pedidos[4] = 70.0
    pedidos.replace(1, 23.0)
    pedidos.replace(4, 41.0)
    pedidos.replace(4, 41.0, 45.5)
    pedidos.remove(4, 45.0)  //só remove se o valor bate
    println(pedidos)

    println("Segunda parte")
    println()

    val pedidos2: MutableMap<Int, Double> = mutableMapOf(
            Pair(1, 2.0),
            Pair(2,64.0),
            3 to 50.0,
            4 to 100.0,
            5 to 150.0,
            6 to 80.0
    )
//    val outroPedido:Double? = pedidos2.getValue(5)  //getValue lança exception se n tiver nada
//                                                    //get() recebe null mesmo que não exista nada
//    println(outroPedido)

    val message:Double? = pedidos2.getOrElse(3, {
        0.0
    }) //pode ser feito dentro de um print

    println(message)

    println(pedidos2.getOrDefault(1,-1.0))
    println(pedidos2.getOrDefault(0,-1.0))

    val keys:List<Int> = pedidos2.keys.toList()
    val values = pedidos2.values

//    for (numerosDePedidos in keys){
//        println(numerosDePedidos)
//    }

//    for (valoresDePedidos in pedidos2.values){
//        println(valoresDePedidos)
//    }

    val pedidosFiltrados = pedidos2.filter { (numero,valor) ->
        numero % 2 == 0 && valor > 50.0
    }

    println(pedidosFiltrados)

    val valoresFiltrados = pedidos2.filterValues { valor ->
        valor >= 50.0
    }

    val numerosFiltrados = pedidos2.filterKeys { chave ->
        chave % 2 == 1
    } //chave impar

    println("Valores filtrados")
    println(valoresFiltrados)
}