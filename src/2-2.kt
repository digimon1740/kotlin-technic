open class Animal(val size: Int) {
    fun feed() = println("Feeding")
}

class Cat(val jump: Int) : Animal(50)
class Dog(val weight: Int) : Animal(80)

class Box<out T : Animal>(val element: T) {
}

fun main(args: Array<String>) {
    val c1: Cat = Cat(10)
    val c2: Dog = Dog(20)

    var a1: Animal = c1 // 하위 자료형이 상위 자료형으로의 변환은 가능(다형성)

    val c3: Box<Cat> = Box<Cat>(c1)
    val c4: Box<Animal> = Box<Cat>(c1)
    val c5: Box<Cat> = Box<Animal>(c1)
}