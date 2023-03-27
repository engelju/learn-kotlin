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

// part 3: operator functions and varargs

fun main() {

    // functions can be "upgraded" to have operators, so you can call them using
    // their correspoding operator symbol.

    operator fun Int.times(msg: String) = msg.repeat(this)
    println(2 * "Bye ")
    
    operator fun String.get(range: IntRange) = substring(range)
    val str = "Dieser Satz wird extra abgeschnitten"
    println(str[0..14])
    
    printAll("Hello", "Hola", "Salut", "Hallo", "Hi")
    log("Hello", "Hola", "Salut", "Hallo", "Hi")
}

// varargs allow you to pass any number of arguments by seperating them with commas.
fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

// vararg is technically an array at runtime. to pass it along as a vararg, use the spread operator "*". 
// this will pass *entries as a vararg of String instead of of entries, an Array<String>.
fun log(vararg entries: String) {
    printAll(*entries)
}

// part 4: variables and null safety

fun main() {
 
    // you can have mutable and immutable variables:
    var a: String = "initial value"		// mutable variable
    val b: Int = 1						// immutable variable

    // you usually let the compiler infer the type of a variable:
    val c = 3
    
    // rule of thumb: use "val" over "var" and skip the types.
     
    // null safety: in an effort to get rid of NullPoinerException, variables in kotlin cannot be assigned "null".
	// if you need a variable that can be null, declare it "nullable" by adding "?" at the end of its type.
    
    var neverNull: String = "this can never be null"
    // neverNull = null			// compiler error
    
    var nullable: String? = "this totally can be null"
    nullable = null
    
    var inferredNonNull = "the compiler assumes non-null"
    // inferredNonNull = null	// compiler error 
    
    fun strLen(notNull: String): Int {
        return notNull.length
    }
    
    strLen(neverNull)
    // strLen(nullable)			// compiler error
    strLen(inferredNonNull)
    
    // if you have to deal with null values (eg. when dealing with Java or truly absent values),
    // Kotlin provides "null-tracking" by using "?" in appropriate places and checking for "null".
    fun describeString(maybeString: String?): String {
        if (maybeString != null && maybeString.length > 0) {
            return "String has length: ${maybeString.length}"
        } else {
            return "Empty or null string"
        }
    }
    
    println(describeString("this is a string"))
    println(describeString(null))
    println(describeString(""))
}




