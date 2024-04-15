open class Person(
    val name: String,
    val lastname: String,
    var age: Int
) {

    fun greet() {
        println("$name says hi!")
    }

    override fun toString(): String {
        return "Person(name='$name', lastname='$lastname', age=$age)"
    }
}

open class Shape(val height: Int, val width: Int) {
    fun draw() {
    }

    open fun fill() {
    }
}

interface MyInterface {
    fun foo()
}

class Rectangle(height: Int, width: Int): Shape(height, width), MyInterface {
    override fun fill() {
    }

    override fun foo() {
        TODO("Not yet implemented")
    }

}

data class User(val name: String, var age: Int)

fun main() {
    val jean = Person("Jean", "Jean", 33)
    val jean2 = Person("Jean", "Jean", 33)
    println(jean)
    jean.greet()

    println(jean == jean2)

    jean.age += 1
    println(jean.age)

    val rect = Rectangle(5, 5)
    println(rect.width)
    println(rect.height)

    val u = User("User", 12)
    val u1 = User("User", 12)
    println(u)
    println(u == u1)
    println(u.equals(u1))

    val u3 = u
    println(u3)

    val u2 = u.copy()
    println(u2)
    println(u == u2)

    u3.age = 10
    println(u3)
    println(u)

    u2.age = 20
    println(u2)
    println(u)
}