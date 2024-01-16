package br.com.alura.alugames.modelo

import java.lang.IllegalArgumentException
import java.util.Scanner
import java.util.regex.Pattern
import kotlin.random.Random

class Gamer(var nome: String, var email: String) : Recomendavel {

    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var id = 0
    var idInterno: String? = null
        private set
    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosBuscados = mutableListOf<Jogo>()
    val jogosAlugados = mutableListOf<Aluguel>()
    private val listaNotasGamer = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()
    override val media: Double
        get() = listaNotasGamer.average()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            println("Nota Inválida. Insira uma nota entre 1 e 10")
        } else {
            listaNotasGamer.add(nota)
        }
    }

    fun recomendarJogo(jogo: Jogo, nota: Int) {
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    constructor(nome: String, email: String, dataNascimento: String?, usuario: String?, id: Int = 0) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        this.id = id
    }

    init {
        if (nome.isBlank()) {
            throw IllegalArgumentException("nome não pode estar em branco")
        }
        validarEmail2()
    }

    override fun toString(): String {
        return "Gamer:\n" +
                "Nome: $nome\n" +
                "Email: $email\n" +
                "Plano: ${plano.tipo}\n" +
                "Data de nascimento: $dataNascimento\n" +
                "Usuario: $usuario\n" +
                "Id : $id\n" +
                "Id Interno: $idInterno\n" +
                "Reputação: %.2f"
                    .format(this.media)
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        this.idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email invalido")
        }
    }

    fun validarEmail2() {
        val regex = Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
        if (!regex) {
            throw IllegalArgumentException("Email inválido!")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(
            gamer = this,
            jogo = jogo,
            periodo = periodo
        )
        jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogosDoMes(mes: Int): List<Jogo> {
        return jogosAlugados
            .filter { aluguel -> aluguel.periodo.dataInicial.monthValue == mes }
            .map { aluguel -> aluguel.jogo }
    }

    fun quantidadeJogosMes(mes: Int) = jogosAlugados.count {
        it.periodo.dataInicial.monthValue == mes
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome = nome, email = email, dataNascimento = nascimento, usuario = usuario)

            } else return Gamer(nome, email)
        }
    }

}