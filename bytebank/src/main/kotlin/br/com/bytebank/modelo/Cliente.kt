package br.com.bytebank.modelo

import br.com.bytebank.recursos_do_paradigma_funcional_curso.teste

class Cliente(
    val nome: String,
    val cpf: String,
    protected val senha: Int,
) : Autenticavel {

    var endereco: Endereco = Endereco()
        private set

    constructor(
        nome: String,
        cpf: String,
        senha: Int,
        endereco: Endereco
    ) : this(
        nome = nome,
        cpf = cpf,
        senha = senha
    ) {
        this.endereco = endereco
    }

    override fun autentica(senha: Int): Boolean {
        if (this.senha == senha) {
            return true
        }
        return false
    }


}
