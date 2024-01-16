package br.com.alura.musicasBD.dados

import javax.persistence.*

@Entity
@Table(name = "bandas")
class BandaEntity(
    val nome: String = "Nome da banda",
    val descricao: String = "Descrição da banda",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
)