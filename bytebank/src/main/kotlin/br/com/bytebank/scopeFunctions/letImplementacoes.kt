package br.com.bytebank.scopeFunctions

import br.com.bytebank.modelo.Autenticavel
import br.com.bytebank.modelo.Endereco
import br.com.bytebank.modelo.SistemaInterno
import kotlin.random.Random

fun letImplementacoesEScopeFunctions() {

//    val endereco = Endereco(rua = "rua verqueiro", numero = 3185)
//    val enderecoEmMaiusculo = "${endereco.rua}, ${endereco.numero}".uppercase()
//    println(enderecoEmMaiusculo)

    /**
     * Return value
     * The scope functions differ by the result they return:
     * - apply and also return the context object.
     * - let, run and with return lambda result.
     */

    //run não precisa de it
    val enderecoEmMaiusculo = Endereco(rua = "rua verqueiro", numero = 3185)
        .run {
            "$rua, $numero".uppercase()
        }.let { enderecoEmMaiusculo: String ->
            println(enderecoEmMaiusculo)
        }

    //exemplo with
    val enderecoWith = Endereco(rua = "rua verqueiro", numero = 3185)
    with(enderecoWith) {
        "$rua,$numero".uppercase()
    }.let(::println)

    listOf(
        Endereco(rua = "rua tipo 1"),
        Endereco(),
        Endereco(rua = "rua tipo 2")
    ).filter(predicate = { endereco -> endereco.rua.isNotEmpty() })
        .let(block = ::println)

    //run pode ser executado sem nenhum vinculo com objeto
    //usado quando inicializa um objeto e logo faz alguma operação com o mesmo
    run {
        println("execução do run sem extensão")
    }

    //apply
    val enderecoApply = Endereco()
        .also { println("Criando o endereço") } //also é para operações simples
        .apply {
            rua = "rua verqueiro"
            numero = 3185
        }


    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) =  this.senha == senha
    }

    val sistema = SistemaInterno()
    sistema.entra(autenticavel, 1234, autenticado = {
        println("realizar pagamento")
    })

    println("HLKJAFHLKJAFHLKAJSH")
    var teste:Double
    sistema.entraReceiver(autenticavel, 1234, autenticado = {
        (it / 2).toDouble()
        //no exemplo da aula o parametro autenticado era somente sistema.() -> unit = {}
        //e no escopo desta chamada seria utilizado somente o metodo pagamento()
    })


    //exemplo apply
    data class Person(var name: String, var age: Int)

    val person = Person("John", 25).apply {
        println("Name: $name, Age: $age")
        age += 5
    }

    println("Updated Age: ${person.age}")


    val number = Random.nextInt(100)

    val evenOrNull = number.takeIf { it % 2 == 0 } //add numero se for par, senao null
    val oddOrNull = number.takeUnless { it % 2 == 0 }//add se nao for par, senao null
    println("even: $evenOrNull, odd: $oddOrNull")

//    soma(1,3){num-> println(num)}
//    soma(3,2, resultado = (::println))

    soma(5, 5, resultado = { valor ->
        println(valor)
    })                                                  //pode nomear it

    somaReceiver(1, 5, resultado = {
        println(this)                                   //só pode usar this
    })

}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("soma sendo efetuada")
    resultado(a + b)
    println("depois da soma")

}

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    println("soma sendo efetuada")
    val total = a + b
    total.resultado()
    println("depois da soma")
}