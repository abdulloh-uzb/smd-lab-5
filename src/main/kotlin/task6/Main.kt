package task6

inline fun <reified T> readValue(prompt: String): T? {
    print(prompt)
    val text = readln().trim()

    return when (T::class) {
        Int::class -> text.toIntOrNull() as T?
        Double::class -> text.toDoubleOrNull() as T?
        Boolean::class -> text.toBooleanStrictOrNull() as T?
        String::class -> text as T?
        Long::class -> text.toLongOrNull() as T?
        else -> error("Unsupported type ${T::class.simpleName}")
    }
}

fun main() {
    val age = readValue<Int>("Age: ")
    val height = readValue<Double>("Height in meters: ")
    val subscribed = readValue<Boolean>("Newsletter (true/false): ")
    val city = readValue<String>("City: ")

    println("age=$age, height=$height, subscribed=$subscribed, city=$city")

    val phone = readValue<Long>("Phone: ")
    println("Phone: $phone")
}

// 25, 1.75, true, Samarkand kiritilganda barcha qiymatlar muvaffaqiyatli o‘qiladi.
//
// x butun son emas, 1,75 nuqta o‘rniga vergul ishlatilgani uchun Double bo‘la olmaydi, yes esa qat’iy Boolean qiymati emas. Ular null qaytaradi. city esa String bo‘lgani uchun oddiy matn sifatida qabul qilinadi.
//
// reified olib tashlansa, T::class va as T? bilan bog‘liq xatolar chiqadi. Generik T turi odatda runtime’da o‘chiriladi (type erasure).
//
// readValue<Char>("City: ") kompilyatsiyadan o‘tadi, ammo bajarilganda else -> error(...) qatorida xato beradi.
//
// Long qo‘shilgach, 998901234567 qiymati Long sifatida o‘qiladi.