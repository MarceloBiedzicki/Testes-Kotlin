package br.com.bytebank.typeSafeBuilderDSL

/**
 * -> o que é inline
 *  - inline vai copiar a implementação da lambda pra dentro da função que chama, isso irá melhorar a performance.
 * -> crossiline
 *  - crossinline fará com que a execução chegue até a implementação da função a qual esteja marcado com crossinline.
 *  - não poderá ser usado return na implementação anterior, assim a execução chegará até ela.
 * -> se a for uma lambda complexa não convem usar inline, pois o bitecode sera imenso.
 * -> noinline
 *  - se for uma inline fun e tenha algum parametro que seja uma highorder function, pode marcar este com noinline
 * -> stack trace
 *  - usando inline fica dificil achar o stacktrace em uma exception. sem ela consegue achar qual lambda
 * ocorreu a exception.
 */

enum class BoardColor {
    BLACK, WHITE, GREEN, BLUE
}

class Atachment {
    var title: String = ""
    var description: String = ""
}

class Task {
    var title: String = ""
    var description: String = ""
    var atachments: MutableList<Atachment> = mutableListOf()

    inline fun atachment(init: Atachment.() -> Unit) {
        val atachment = Atachment()
        atachment.init()
        atachments.add(atachment)
    }
}

class Board {
    var title: String = ""
    var color: BoardColor = BoardColor.BLUE
    var tasks: MutableList<Task> = mutableListOf()

    inline fun task(init: Task.() -> Unit) {
        val task = Task()
        task.init()
        tasks.add(task)
    }
}


inline fun board(init: Board.() -> Unit): Board {
    val board = Board()
    board.init()
    return board
}

fun typeSafeBuilderYoutube1() {

    val board = board {
        title = "Board 1"
        color = BoardColor.GREEN

        task {
            title = "Task 1"
            description = "Task 1 Description"
            atachment {
                title = "Atachment 1"
                description = "Description 1"
            }
            atachment {
                title = "Atachment 2"
                description = "Description 2"
            }
        }
        task {
            title = "Task 2"
            description = "Task 2 Description"
            atachment {
                title = "Atachment 1"
                description = "Descrition 2"
            }
            atachment {
                title = "Atachment 2"
                description = "Description 2"
            }
        }

        var num = 1
        repetir(5){
            println(num)
            num ++
        }
    }

    println(
        """
        Instancia Quadro - 
            Titulo ${board.title}
            Color ${board.color}
        Task - 
            Title ${board.tasks[0].title}
            Description ${board.tasks[0].description}
        Atachment - 
            Title ${board.tasks[0].atachments[0].title}
            Description ${board.tasks[0].atachments[0].description}
    """.trimIndent()
    )



}
inline fun repetir(times: Int, crossinline action: () -> Unit){
    for (i in 1 .. times){
        action()
        if (i == 3){
            println("num 3 print")
        }
    }
}