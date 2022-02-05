// 3.2.4
class FunFunctions {

    var percent1 = 5
    private var percent2 = 9
    val percent3 = 13

    fun add(a: Int, b: Int): Int = a + b// 순수함수

    fun mult(a: Int, b: Int?): Int = 5// 순수함수(상수)

    fun div(a: Int, b: Int): Int = a / b// 순수함수 아님

    fun div(a: Double, b: Double): Double = a / b// 순수함수

    fun applyTax1(a: Int): Int = a / 100 * (100 + percent1)// 순수함수 아님

    fun applyTax11(ff: FunFunctions, a: Int): Int = a / 100 * (100 + ff.percent1)// 순수함수

    fun applyTax2(a: Int): Int = a / 100 * (100 + percent2)// 순수함수

    fun applyTax3(a: Int): Int = a / 100 * (100 + percent3)// 순수함수

    fun append(i: Int, list: MutableList<Int>): List<Int> {// 순수함수 아님
        list.add(i)
        return list
    }

    fun append2(i: Int, list: List<Int>) = list + i // 순수함수
}

// 3.2.6
fun double(x: Int): Int = x * 2
val double2: (Int) -> Int = { x -> x * 2 }

val doubleThenIncrement: (Int) -> Int = { x ->
    val double = x * 2
    double + 1
}

val add: (Int, Int) -> Int = { x, y -> x + y }

val double3: (Int) -> Int = { it * 2 }


// 3.2.7
val multiplyBy1: (Int) -> Int = { n -> double(n) }
val multiplyBy2: (Int) -> Int = { double(it) }
val multiplyBy3: (Int) -> Int = ::double

class MyClass {
    fun double(n: Int): Int = n * 2
}

val foo = MyClass()
val multiplyBy4: (Int) -> Int = foo::double
val multiplyBy5: (MyClass, Int) -> Int = MyClass::double

class MyClass2 {
    companion object {
        fun double(n: Int): Int = n * 2
    }
}

val multiplyBy6: (Int) -> Int = MyClass2.Companion::double
val multiplyBy7: (Int) -> Int = (MyClass2)::double


// 연습문제 3-1
fun square(n: Int) = n * n
fun triple(n: Int) = n * 3

fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }


fun main() {
    println(square(triple(2)))
    val squareOfTriple = compose(::square, ::triple)
    println(squareOfTriple(2))

}
