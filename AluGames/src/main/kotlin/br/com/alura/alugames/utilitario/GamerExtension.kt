package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.GamerEntity
import br.com.alura.alugames.modelo.Gamer

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.id, this.nome, this.email, this.dataNascimento, this.usuario, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}
