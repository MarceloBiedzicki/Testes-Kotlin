package br.com.bytebank.typeSafeBuilderDSL

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

    fun atachment(init: Atachment.() -> Unit) {
        val atachment = Atachment()
        atachment.init()
        atachments.add(atachment)
    }
}

class Board {
    var title: String = ""
    var color: BoardColor = BoardColor.BLUE
    var tasks: MutableList<Task> = mutableListOf()

    fun task(init: Task.() -> Unit) {
        val task = Task()
        task.init()
        tasks.add(task)
    }
}

fun board(init: Board.() -> Unit): Board {
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