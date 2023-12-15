package br.com.bytebank.teste

data class Member(val name: String, val isSpecial: Boolean)
var savedSpecialInvite: ((Member) -> Unit)? = null

fun testeInlin() {

    val membersList = listOf<Member>(
        Member("Alice", false),
        Member("Bob", true),
        Member("Charlie", false),
        Member("Diana", true)
    )

    organizeEvent(
        "Potato Party",
        membersList,
        { member -> println("General notification sent to ${member.name}!") },
        { member -> println("Special invitation prepared for ${member.name}!") }
    )
    
    println("\n --- Some time passes --- \n")
    
    dispatchSavedInvites(membersList)
}

fun dispatchSavedInvites(membersList: List<Member>) {
    savedSpecialInvite?.let { inviteFun ->
        for (member in membersList.filter { it.isSpecial }){
            inviteFun(member)
        }
    }

}

inline fun organizeEvent(
    eventName: String,
    members: List<Member>,
    generalNotifier: (Member) -> Unit,
    noinline specialInvite: (Member) -> Unit
) {
    println("Organizing event: $eventName")

    //save the special invite lambda for later use
    savedSpecialInvite = specialInvite //somente pode atribuir a função porque existe noinline
                                       //se fosse inline o compilador não permitiria
    for (member in members) {
        if (!member.isSpecial) {
            generalNotifier(member)
        }
    } //special membersare not notified yet
}
