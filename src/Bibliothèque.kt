import lib.Library

interface Borrowable {
    fun borrow(user: BookReader): Boolean
    fun returnItem(user: BookReader)
}

open class Item(val title: String, val author: String, val year: Int) {
    var isAvailable = true
}

class BookReader(val name: String) {
    val id = ++count
    val borrowedItems = mutableListOf<Item>()

    companion object {
        var count = 0
    }

    fun borrow(item: Item): Boolean =
        if (item is Borrowable) {
            val isBorrowed = item.borrow(this)
            if (isBorrowed) {
                borrowedItems.add(item)
            }
            isBorrowed
        }
        else {
            false
        }

    fun returnItem(item: Item) {
        if (item !is Borrowable) {
            return
        }
        item.returnItem(this)
        borrowedItems.remove(item)
    }

    override fun toString(): String {
        return "BookReader(name='$name', id=$id, borrowedItems=$borrowedItems)"
    }


}

class Book(title: String, author: String, year: Int, val genre: String): Item(title, author, year), Borrowable {
    override fun borrow(user: BookReader): Boolean {
        if (!isAvailable) {
            println("$title is not available for borrowing")
            return false
        }
        isAvailable = false
        println("$title has been borrowed by ${user.name}")
        return true
    }

    override fun returnItem(user: BookReader) {
        isAvailable = true
        println("$title has been returned by ${user.name}")
    }

}

fun main() {
    val lib = Library("lib")
    val lib1 = Library("lib1")
    val lib2 = Library("lib2")

    val myLibs = listOf(lib, lib1, lib2)

    myLibs.forEach(System.out::println)

    lib.editMessage("Bonjour")
    myLibs.forEach(Library::readMessage)

}

fun test() {
    val kotlinProg = Book("Kotlin Programming", "Jane Doe", 2021,
        "Education")
    val flutterPro = Book("Flutter Programming", "Majid", 2023,
        "Education")
    val harryPotter = Book("Harry Potter", "JK Rowling", 1995,
        "Novel")
    val jeanMichel = BookReader("Jean Michel")
    val robert = BookReader("Robert Jackson")

    jeanMichel.borrow(kotlinProg)
    robert.borrow(kotlinProg)
    robert.borrow(flutterPro)
    jeanMichel.returnItem(kotlinProg)
    robert.returnItem(flutterPro)

    println(jeanMichel)
    println(robert)
}

