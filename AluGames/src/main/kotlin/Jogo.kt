data class Jogo(
    val titulo: String,
    val capa: String
) {

    var descricao: String = ""

    override fun toString(): String {
        return "Jogo: $titulo\n" +
                "Capa: $capa\n" +
                "Descrição: $descricao\n"
    }


}
