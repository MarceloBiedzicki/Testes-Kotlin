package br.com.alura.alugames.modelo

data class Jogo(
    val titulo: String?,
    val capa: String?
) {
    var descricao: String? = "Ainda não adicionada"
    var numero = 0

    override fun toString(): String {
        return "Titulo: $titulo\n" +
                "Capa: $capa\n" +
                "Descrição:\n - $descricao\n\n"
    }


}
