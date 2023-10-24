package br.com.alura.collections

class BancoDeNomes {                                                 //get usado para não deixar a atribuição virar
    val nomes: Collection<String> get() = Companion.dados.toList()   //ponteiro e sim uma atribuição de getter

    fun salva(nome: String){
        Companion.dados.add(nome)
    }

    companion object {
        private val dados = mutableListOf<String>()
    }
}