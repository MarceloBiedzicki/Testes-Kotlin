package br.com.bytebank.modelo

class SistemaInterno {

    fun entra(autenticavel: Autenticavel, senha: Int, autenticado: () -> Unit = {}) {
        if (autenticavel.autentica(senha)) {
            println("Bem vindo ao Bytebank")
            autenticado()
        } else {
            println("Falha na autenticação")
        }
    }

    fun entraReceiver(autenticavel: Autenticavel, senha: Int, autenticado: SistemaInterno.(Int) -> Double = {0.0}) {
        if (autenticavel.autentica(senha)) {
            println("Bem vindo ao Bytebank")
            val batata = autenticado(senha)
            println(batata)
        } else {
            println("Falha na autenticação")
        }
    }

    fun pagamento() {
        println("realizando pagamento")
    }
}