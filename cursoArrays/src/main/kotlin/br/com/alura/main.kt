package br.com.alura

fun main() {

    val assitiramCursoAndroid: List<String> = listOf("Alex","Fran","Gui","Maria")
    val assistiramCursoKotlin: List<String> = listOf("Alex","Paulo","Maria")
//    val assistiramAmbos: MutableList<String> = mutableListOf<String>()
    val assistiramAmbos = assistiramCursoKotlin + assitiramCursoAndroid

//    assistiramAmbos.addAll(assistiramCursoKotlin)
//    assistiramAmbos.addAll(assitiramCursoAndroid)

    println(assistiramAmbos.distinct())


}




