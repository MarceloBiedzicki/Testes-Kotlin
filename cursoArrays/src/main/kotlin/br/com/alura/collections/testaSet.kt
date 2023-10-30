package br.com.alura.collections

fun comportamentos() {
    val assitiramCursoAndroid: Set<String> = setOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin: List<String> = listOf("Alex", "Paulo", "Maria")       //poderia usar mutableSetOf<String>
//    val assistiramAmbos: MutableList<String> = mutableListOf<String>()           //e adicionar elementos
    val assistiramAmbos: Set<String> = assitiramCursoAndroid + assistiramCursoKotlin
    //a primeira referencia usada na soma sera o tipo que retornará da soma
    //por exemplo assistiramAmbos é Set<String> devido ao primeiro elemento da soma ser um set

//    assistiramAmbos.addAll(assistiramCursoKotlin)
//    assistiramAmbos.addAll(assitiramCursoAndroid)

    println(assistiramAmbos.distinct())
//    println(assistiramAmbos[0])  //não compila por ser um set

    println(assitiramCursoAndroid union assistiramCursoKotlin) // exatamente o mesmo com o + porem a implementação é
    // diferente e pode chamar o metodo sem o "." nem "( )"
    //caracteristica infix

    println(assistiramCursoKotlin - assitiramCursoAndroid)

    println(assitiramCursoAndroid subtract assistiramCursoKotlin)  //subtract é o oposto de union

    println(assitiramCursoAndroid intersect assistiramCursoKotlin)  //pega os elementos que tem em ambos

    val toMutableList = assistiramAmbos.toMutableList()
    toMutableList.add("Alex")
    println(toMutableList)

    val toSet = toMutableList.toSet()
    println(toSet)
}