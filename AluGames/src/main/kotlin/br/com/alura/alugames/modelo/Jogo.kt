package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose
import java.math.BigDecimal
import javax.persistence.*

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

    var id = 0

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String?, id: Int = 0) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "- Titulo: $titulo\n" +
                "  - Capa: $capa\n" +
                "  - Id: $id \n" +
                "  - Preço: $preco\n" +
                "  - Nota: %.2f \n"
                    .format(media) +
                "  - Descrição:\n " +
                " - $descricao\n\n"
    }
}
