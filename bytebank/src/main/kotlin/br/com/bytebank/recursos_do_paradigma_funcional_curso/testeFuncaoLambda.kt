package br.com.bytebank.recursos_do_paradigma_funcional_curso

fun testeFuncaoLambda() {

    val minhaFuncaoLambda: () -> Unit = {
        println("Executa como lambda")
    }

    println(minhaFuncaoLambda())

    val minhaFuncaoLambdaComRetorno = { a: Int, b: Int ->
        println("Executa como Lambda 1")
        a + b
    }

    println(minhaFuncaoLambdaComRetorno(3, 2))

    val minhaFuncaoLambdaComRetorno2: (Int, Int) -> Int = { a, b ->
        println("Executa como Lambda 2")
        a + b
    }

    println(minhaFuncaoLambdaComRetorno2(2, 3))

    val minhaFuncaoAnonima: () -> Unit = fun() {
        println("Executando minha funcao anonima")
    }
    println(minhaFuncaoAnonima())

    val minhaFuncaoAnonima2 = fun(a: Int, b: Int): Int {
        return a + b  //diferente da lambda não é a ultima linha que retorna
    }                 //precisa especificar o return

//    val minhaFuncaoAnonima2: (Int, Int) -> Int = fun(a, b): Int {
//        return a + b
//    }
    //abaixo por ter um unico parametro o it aparecera como no let
    //convem usar uma identificação para o parametro quando unico
    val calculaBonificacao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            return@lambda salario + 50.0
        }//sem o lambda@ o return sai do main
        salario + 100.0
    }
    println(calculaBonificacao(1100.0))

    val calculaBonificacaoAnonima: (salario: Double) -> Double = fun (salario): Double {
        if (salario > 1000.0) {
            return salario + 50.0
        }
        return salario + 100.0
    }
    println(calculaBonificacaoAnonima(1010.0))

}