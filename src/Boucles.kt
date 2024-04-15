fun main() {
    val rainbowColors = listOf("red", "orange", "yellow", "green", "blue", "indigo", "violet")

    for ((index, color) in rainbowColors.withIndex()) {
        println("$index: $color")
    }

    var i = 0
    while (i < rainbowColors.size) {
        println("$i: ${rainbowColors[i]}")
        i++
    }

}