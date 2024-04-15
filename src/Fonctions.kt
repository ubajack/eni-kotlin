/*
Conversion d'un range de 0 à 255 vers une chaine de 00 à FF
 */
fun RGBtoHEX(red: Int, green: Int, blue: Int): String {
    val redHEX = Integer.toHexString(red)
        .padStart(2, '0')
        .uppercase()
    val greenHEX = Integer.toHexString(green)
        .padStart(2, '0')
        .uppercase()
    val blueHEX = Integer.toHexString(blue)
        .padStart(2, '0')
        .uppercase()
    val result = "$redHEX$greenHEX$blueHEX"
    return result
}

fun intToHexConverter(colorValue: Int): String {
    return Integer.toHexString(colorValue)
        .padStart(2, '0')
        .uppercase()
}

fun intToHexConverterv2(colorValue: Int) =
    Integer.toHexString(colorValue)
        .padStart(2, '0')
        .uppercase()

fun RGBtoHEXv2(red: Int, green: Int, blue: Int): String {
    // Conversion de la couleur rouge
    val redHEX = intToHexConverterv2(red)
    // Conversion de la couleur verte
    val greenHEX = intToHexConverterv2(green)
    // Conversion de la couleur bleue
    val blueHEX = intToHexConverterv2(blue)
    return "$redHEX$greenHEX$blueHEX"
}

// https://kotlinlang.org/docs/extensions.html
// https://kotlinlang.org/docs/functions.html#infix-notation
infix fun Int.plus(valueToAdd: Int) = this + valueToAdd

infix fun Int.plusv2(other: Int): Int {
    return this + other
}

infix fun String.bonjour(name: String) = "$this dit bonjour à $name"

fun main() {
    val colorRGB = Triple(233, 150, 122)
    val colorHEX = RGBtoHEXv2(colorRGB.first, colorRGB.second, colorRGB.third)
    println(colorHEX)

    val a = 2
    val b = 8

    a plus b

    val result = a.plus(b)
    val result1 = a plus b

    println(result1)

    val pierre = "Pierre"
    val paul = "Paul"

    println(pierre bonjour paul)
}