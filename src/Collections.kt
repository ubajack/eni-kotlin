import kotlin.random.Random

fun <T> occurrencesCount(items: List<T>, target: T) =
    items.filter { it == target }.count()

fun <T> List<T>.countOccurrences(target: T) = this.count { it == target }

fun main() {
    val fries = "\uD83C\uDF5F"
    val burger = "\uD83C\uDF54"

    val burgersAndFries = mutableListOf(
        fries,
        burger,
        fries,
        fries,
        burger
    )

    var count = 0
    /*
    for (i in 0..< burgersAndFries.size) {
        if (burgersAndFries[i] == fries) {
            count++
        }
    }
    */
    /*
    for (item in burgersAndFries) {
        if (item == fries) {
            count++
        }
    }
    */
    /*
    burgersAndFries.forEach { item ->
        count += if (item == fries) 1 else 0
    }
    */
    burgersAndFries.forEach {
        count += if (it == fries) 1 else 0
    }
    println("Total number of fries: $count")

    val friesOnly = burgersAndFries.filter {
        it == fries
    }
    val friesCount = friesOnly.count()
    println(burgersAndFries)
    println(friesOnly)
    println(friesCount)

    val targetNumber = 10
    val randomList = (0 ..< 10).map { Random.nextInt(11) }
    println(randomList)
    println("Testing function for fries: ${occurrencesCount(burgersAndFries, fries)}")
    println("Testing function for number $targetNumber: ${occurrencesCount(randomList, targetNumber)}")
    println(burgersAndFries.countOccurrences(fries))
    println(randomList.countOccurrences(targetNumber))
}