import kotlin.random.Random

fun main() {
    val note = Random.nextInt(21)
    println("note: $note")

    // A : 14 -> 20
    // B : 11 -> 13
    // C : 8 -> 10
    // D : 5 -> 7
    // E : 1 -> 5
    // F : 0

    if (note >= 14) {
        println("A")
    } else if (note >= 11) {
        println("B")
    } else if (note >= 8) {
        println("C")
    } else if (note >= 5) {
        println("D")
    } else if (note >= 1) {
        println("E")
    } else {
        println("F")
    }

    when(note) {
        in 14 .. 20 -> println("A")
        in 11 .. 13 -> println("B")
        in 8 .. 10 -> println("C")
        in 5 .. 7 -> println("D")
        in 1 .. 4 -> println("E")
        else -> println("F")
    }
}