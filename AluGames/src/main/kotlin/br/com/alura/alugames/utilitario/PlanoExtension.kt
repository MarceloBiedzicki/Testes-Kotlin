package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.PlanoAssinaturaEntity
import br.com.alura.alugames.dados.PlanoAvulsoEntity
import br.com.alura.alugames.dados.PlanoEntity
import br.com.alura.alugames.modelo.Plano
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.modelo.PlanoAvulso

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(
            this.tipo,
            this.mensalidade.toDouble(),
            this.jogosIncluidos,
            this.percentualDescontoReputacao.toDouble(),
            this.id
        )
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(
            this.tipo,
            this.mensalidade.toBigDecimal(),
            this.jogosIncluidos,
            this.percentualDescontoReputacao.toBigDecimal(),
            this.id
        )
    } else {
        PlanoAvulso(
            this.tipo,
            this.id
        )
    }
}