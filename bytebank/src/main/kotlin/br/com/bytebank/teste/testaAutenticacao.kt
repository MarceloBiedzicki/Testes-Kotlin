package br.com.bytebank.teste

import br.com.bytebank.modelo.*

fun testaAutencicacao() {

    val gerente = Gerente(
        cpf = "111.111.111-11",
        nome = "Jose",
        salario = 1000.0,
        senha = 1000
    )

    val diretor = Diretor(
        cpf = "111.111.111-22",
        nome = "Dariel",
        salario = 2000.0,
        plr = 500.0,
        senha = 2000
    )

    val cliente = Cliente(
        nome = "João",
        cpf = "111.111.111-23",
        senha = 12345,
        endereco = Endereco(
            rua = "",
            numero = 1,
            bairro = "",
            cidade = ""
        )
    )

    val sistema = SistemaInterno()
    sistema.entra(gerente, 1000)
    sistema.entra(autenticavel = diretor, senha = 2000)
    sistema.entra(cliente, 2000)
}
