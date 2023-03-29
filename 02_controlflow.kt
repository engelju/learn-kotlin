// part 1: when

// use "when" instead of "switch" - can be used as statement OR expression

// when statement:
// 
// branch conds are checked sequentially until one of them matches (only first suitable branch will be executed).
// the default branch (else) may be omitted.

fun cases(obj: Any) {
    print("$obj is... ")
    when (obj) {
        1 			-> println("One")
        "Hello" 	-> println("Greeting")
        is Long		-> println("Long Int")
        !is String	-> println("Not a String")
        else		-> println("unknown")
    }
}

class MyClass

// when expression

fun whenAssign(obj: Any): Any {
    var result = when (obj) {
        1 		-> "one"
        "Hello" -> 1
        is Long -> false
        else 	-> 42
    }
    return result
}

fun main() {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
    
    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(MyClass()))
}


