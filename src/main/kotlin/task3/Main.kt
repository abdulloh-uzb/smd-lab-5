package task3

val contacts = listOf("Ali Karimov", "Dilnoza Yusupova", "Aliyah Smith", "Bobur Aliev")

fun findFirst(query: String) {
    contacts.forEach {
        if (it.contains(query, ignoreCase = true)) {
            println("First match: $it")
            return
        }
    }
    println("No contact contains '$query'")
}

fun findAll(query: String) {
    contacts.forEach {
        if (!it.contains(query, ignoreCase = true)) return@forEach
        println("Match: $it")
    }
}


fun main() {
    print("Search: ")
    val query = readln().trim()
    findFirst(query)
    findAll(query)
    println("Search finished")
}

inline fun each(items: List<String>, action: (String) -> Unit) {
    for (item in items) action(item)
}

fun findWithEach(query: String) {
    each(contacts) {
        if (it.contains(query, ignoreCase = true)) {
            println("First match: $it")
            return
        }
    }
}


//1, chunki findAll hamma moslarni qidiradi, findFirst esa birinchi topganda return qilib loopdan chiqib ketadi
// 2. ikkovi bir xil
// 3. chunki "Search finished" main ga tegishli
// 4. each inline emas, foreach esa inline va shu sababli foreach non-local ni return qilishga allow qiladi
// 5.a bare return is allowed in a lambda when it is in inline function

