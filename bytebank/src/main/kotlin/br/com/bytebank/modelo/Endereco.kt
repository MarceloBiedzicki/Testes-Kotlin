package br.com.bytebank.modelo

class Endereco(
    var rua: String = "",
    var numero: Int? = null,
    var cep: String = "",
    var bairro: String? = null,
    var cidade: String = ""
) {
    override fun toString(): String {
        return """"
            |   Endereco: 
            |Rua: $rua, 
            |Numero: $numero,
            |Bairro: $bairro,
            |Cidade: $cidade""".trimMargin()

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco

        if (rua != other.rua) return false
        if (numero != other.numero) return false
        if (cep != other.cep) return false
        if (bairro != other.bairro) return false
        return cidade == other.cidade
    }

    override fun hashCode(): Int {
        var result = rua.hashCode()
        result = 31 * result + numero!!
        result = 31 * result + cep.hashCode()
        result = 31 * result + bairro.hashCode()
        result = 31 * result + cidade.hashCode()
        return result
    }

}
