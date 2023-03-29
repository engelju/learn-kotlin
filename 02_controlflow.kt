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

// part 2: loops
// kotlin supports all types of loops: for, while, do-while

fun main() {
    
    // for
    
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }

    // while and do-while
    
    fun eatACake() = println("Eat a Cake")
	fun bakeACake() = println("Bake a Cake")
    
    var cakesEaten = 0
    var cakesBaked = 0
    
    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }
    
    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}

// you can also use iterators:

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {
    
    operator fun iterator(): Iterator<Animal> {
		return animals.iterator()
    }
}

fun main() {
    val zoo = Zoo(listOf(Animal("Zebra"), Animal("Tiger")))
    for (animal in zoo) {
        println("watch out, it's a ${animal.name}")
    }
}
