package lib

class Library(val name: String) {

    val id = ++countOfInstances

    companion object {
        var countOfInstances = 0
        var message = ""
    }

    fun readMessage() = println(message)

    fun editMessage(text: String) {
        message = text
    }

    override fun toString(): String {
        return "Library(name='$name', id=$id)"
    }
}