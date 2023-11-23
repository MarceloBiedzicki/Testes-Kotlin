package br.com.alura.collections

import br.com.alura.Item
import br.com.alura.Pessoa

fun testeAgrupamentos() {
    val pedidos: List<Pedido> = listOf(
            Pedido(1, 20.0),
            Pedido(2, 60.0),
            Pedido(3, 30.0),
            Pedido(4, 70.0)
    )

    println(pedidos)

    val pedidosMapeados: Map<Int, Pedido> = pedidos.associate { pedido: Pedido ->
        Pair(pedido.numero, pedido) // pode usar o prefix to
    }

    val pedidosMapeados2: Map<Int, Pedido> = pedidos.associateBy { pedido ->
        pedido.numero
    } //resultado igual a pedidosMapeados

    val pedidosFreteGratis = pedidos.associateWith { pedido ->
        pedido.valor > 50.0
    }

    println(pedidosMapeados)
    println(pedidosMapeados[1])
    println("Pedidos frete gratis")
    println(pedidosFreteGratis)
    println("Buscando um pedido em especifico /true or false")
    println(pedidosFreteGratis[Pedido(1, 20.0)])

    //tentativa de outra maneira para fretesGratis
    //a chave não pode repetir então terá somente 1 true e 1 false

//    val freteGratisAssociateBy = pedidos.associateBy { pedido ->
//        pedido.valor > 50 }

    val groupByPedidosFreteGratis = pedidos.groupBy { pedido: Pedido ->
        pedido.valor > 50.0
    }

    println(groupByPedidosFreteGratis)
    println(groupByPedidosFreteGratis[true])

    val nomes = listOf("Alex",
            "Fran",
            "Gui",
            "Ana",
            "Paulo",
            "Maria",
            "Mario",
            "Gisele")

    val agenda: Map<Char, List<String>> = nomes.groupBy { nomes ->
        nomes.first()
    }

    println(agenda['M'])

    val nomesGrouping: Grouping<String, Boolean> = nomes.groupingBy { nome ->
        nome.startsWith('M')
    }

    println(nomesGrouping.eachCount())

    val pessoas = listOf(
            Pessoa("Alex", 30),
            Pessoa("Ana", 25),
            Pessoa("Paulo", 35),
            Pessoa("Maria", 28),
            Pessoa("Marta", 32),
            Pessoa("Gui", 31),
            Pessoa("Gisele", 27)
    )

    val gruposPorInicial = pessoas.groupBy { it.nome.first() }

    val mediasPorGrupo = gruposPorInicial.mapValues { (_, pessoasNoGrupo) ->
        val somaDasIdades = pessoasNoGrupo.sumOf { it.idade }
        val mediaDasIdades = somaDasIdades.toDouble() / pessoasNoGrupo.size
        mediaDasIdades
    }

    println(mediasPorGrupo)


    val items = listOf(
            Item("A", 10),
            Item("B", 20),
            Item("A", 30),
            Item("B", 40),
            Item("C", 50)
    )

    val groupedItems = items.groupBy(Item::category)
            .mapValues { entry ->
                entry.value.map(Item::value).sum()
            }


    println(groupedItems)
}