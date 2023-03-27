// part 1: default parameter values and named arguments

fun main(args: Array<String>) {
    println(args.contentToString())
    
    printMessage("julie")
    
    // different ways to pass arguments
    printMessageWithPrefix("julie again")
    printMessageWithPrefix("julie again", "Error")
    printMessageWithPrefix(prefix="Log", message="julie again")
    
    println(sum(1, 2))
    println(multiply(2, 4))
}

fun printMessage(message: String) {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y;

// part 2: infix functions

// There is this concept of `infix functions`, which I think means "in between".
// Member functions and extensions with a single parameter can be turned into `infix` functions.
// They are marked by the infix keyword and can also be called using the infix notation (omitting
// the dot and the parentheses for the call).

fun main() {
    // define an infix function as an extension to Int
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")
    
    // there are also infix functions already present, like "to" which is part of the standard library.
    val aPair = "Julie" to "Sonia"
    println(aPair)
    
    // create our own implementation of "to"
    infix fun String.onto(other: String) = Pair(this, other)
    val anotherPair = "Sonia" onto "Julie"
    println(anotherPair)
    
    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    // infix notation also worjs on member functions (ie. class methods)
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }
}
