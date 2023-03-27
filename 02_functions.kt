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
