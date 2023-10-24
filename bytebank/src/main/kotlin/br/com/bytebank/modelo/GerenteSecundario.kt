package br.com.bytebank.modelo

class GerenteSecundario : Funcionario {

    private var senha: String? = null

    constructor(
        nome: String,
        cpf: String,
        salario: Double,
        senha: String
    ) : super(
            nome = nome,
            cpf = cpf,
            salario = salario
            ){
        this.senha = senha
    }

    override val bonificacao: Double
        get() = salario


}