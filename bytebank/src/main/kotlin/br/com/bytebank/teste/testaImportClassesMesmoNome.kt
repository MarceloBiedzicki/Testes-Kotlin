package br.com.bytebank.teste

import br.com.bytebank.modelo.Cliente
import br.com.bytebank.modelo.Endereco
import br.com.bytebank.modelo2.Cliente as Cliente2

/**
 * Existe tanto classe Cliente em modelo2 quanto em modelo.
 * Desta forma usar "as" para referenciar outro nome onde esta sendo usado.
 */
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