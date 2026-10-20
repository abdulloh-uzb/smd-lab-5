package task2

val pending = mutableListOf<() -> Unit>()

inline fun addTask(save: () -> Unit, noinline reminder: () -> Unit) {
    save()

//    pending.add(save)

    pending.add(reminder)
}

fun main() {
    print("Task name: ")
    val name = readln().trim()
    addTask(
        save = { println("Saved: $name") },
        reminder = { println("Reminder: finish '$name'") },
    )
    println("Pending reminders: ${pending.size}")
    pending.forEach { it() }
}

// 1. reminder inline function ichida bo'lgani uchun xato beradi
// 2. ketma ketlik: 1) Saved: write report 2) Pending reminders: 1  3) Reminder: finish 'write report'
// 3. save ni listga qo'shib bo'lmaydi chunki u inline, agar noinline qilsa add qilib listga qo'shsa bo'ladi
// 4. pending lisda saql;anadi.



