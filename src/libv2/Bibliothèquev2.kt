package libv2

/*
(Une classe Item)
Une classe utilisateur :
 - emprunter un livre
 - rendre un livre
 - collection de livres
 Une classe livre :
 - disponible ou non
 - attributs...
 */

data class Book(val title: String) {

    private fun changeStoreState(state: Boolean) {
        Store.booksInLibrary.put(this, state)
    }

    private fun getStoreState() = Store.booksInLibrary[this]

    fun borrow(): Boolean {
        if (getStoreState()!!) {
            return false
        }
        changeStoreState(true)
        return true
    }

    fun giveBack() {
        changeStoreState(false)
    }
}

class User(val name: String) {
    val booksCollection = mutableListOf<Book>()

    fun borrow(book: Book) {
        if (book.borrow()) {
            booksCollection.add(book)
        }
    }

    fun giveBack(book: Book) {
        book.giveBack()
        booksCollection.remove(book)
    }
}

fun main() {
    val listOfBooks = Store.booksInLibrary.keys.toList()

    val u = User("U")
    u.borrow(listOfBooks.random())

    println(Store.booksInLibrary)
}