package br.com.bytebank.modelo

import br.com.bytebank.recursos_do_paradigma_funcional_curso.teste

class Cliente(
    val nome: String,
    val cpf: String,
    val endereco: Endereco,
    protected val senha: Int,
) : Autenticavel {

    override fun autentica(senha: Int): Boolean {
        if (this.senha == senha) {
            return true
        }
        return false
    }


}
