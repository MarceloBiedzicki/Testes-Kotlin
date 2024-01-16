package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "gamers")
data class GamerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val nome: String = "Nome do gamer",
    val email: String = "Email do gamer",
    val dataNascimento: String? = "Data de nascimento do gamer",
    val usuario: String? = "Nome do usuario",
    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()
)