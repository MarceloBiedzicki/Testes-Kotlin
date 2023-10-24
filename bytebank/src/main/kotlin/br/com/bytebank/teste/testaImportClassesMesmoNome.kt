package br.com.bytebank.teste

import br.com.bytebank.modelo2.Cliente as Cliente2
import br.com.bytebank.modelo.Cliente
import br.com.bytebank.modelo.Endereco

fun testaImportClassesMesmoNome() {
    val cliente = Cliente(
        nome = "",
        cpf = "",
        senha = 1,
        endereco = Endereco(
            "",
            1,
            "",
            ""
        )
    )
    val cliente2 = Cliente2()
}