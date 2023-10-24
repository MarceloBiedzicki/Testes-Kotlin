package br.com.bytebank.teste

fun funcaoTaxa(valorRecebido: Double?) : Double?{
    if (valorRecebido != null){
        return valorRecebido + 0.1
    }
    return null
}