package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose
import java.math.BigDecimal

class Jogo(
    @Expose val titulo: String,
    @Expose val capa: String
) : Recomendavel {
    var descricao: String? = null
    var numero = 0
    var preco = BigDecimal("0.0")
    private val listaNotas: MutableList<Int> = mutableListOf()
    override val media: Double
        get() = listaNotas.average()

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "- Titulo: $titulo\n" +
                "  - Capa: $capa\n" +
                "  - Nota: %.2f \n"
                    .format(this.media) +
                "  - Descrição:\n " +
                " - $descricao\n\n"
    }
}
