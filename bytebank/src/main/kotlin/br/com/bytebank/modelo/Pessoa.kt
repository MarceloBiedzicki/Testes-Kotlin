package br.com.bytebank.modelo

data class Pessoa(val nome: String, val idade: Int) {

    fun fala(): String {
        return "reproduzirSom"
    }
}