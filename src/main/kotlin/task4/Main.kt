package task4

inline fun command(crossinline action: () -> Unit): Runnable =
    Runnable { action() }

fun main() {
    val commands = mapOf(
        "1" to command { println("Hello!") },
        "2" to command { println("Goodbye!") },
        "3" to command { println("Time to rest.") },
        "4" to command { println("Settings opened") }
    )

    print("Choose 1, 2, 3 or 4: ")
    val chosen = commands[readln().trim()]
    if (chosen == null) println("Unknown command") else chosen.run()
}

//1. The compiler names the action parameter and suggests adding the crossinline modifier.
//
//2. When I enter 2, the program prints Goodbye!. When I enter 9, it prints Unknown command.
//
//3. In Task 3, forEach is an inline function that allows a non-local return. In Task 4, the lambda is called inside a Runnable object, so crossinline prevents a non-local return.
//
//4. Command 4 prints Settings opened.

