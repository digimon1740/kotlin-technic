import java.util.function.IntUnaryOperator

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

val square: (Int) -> Int = { n -> n * n }
val triple: (Int) -> Int = { n -> n * 3 }
val compose: ((Int) -> Int) -> ((Int) -> Int) -> (Int) -> Int =
    { x ->
        { y ->
            { z ->
                x(y(z))
            }
        }
    }

typealias IntUnaryOp = (Int) -> Int

val square2: IntUnaryOp = { it * it }
val square3: IntUnaryOperator = IntUnaryOperator {
    it * 2
}

fun main() {
    println("==========")
    val squareOfTriple = compose(::square, ::triple)
    println(squareOfTriple(2))

    println("==========")
    val squareOfTriple2 = compose(square, triple)
    println(squareOfTriple2(2))

    println("==========")
    println(add2(1)(2))
    println(add3(1)(3))

    addTax(taxRate)(12.0)

    addTax2(taxRate)(12.00)

    println("==========")
    println(partialA<Int, Int, Int>(10) { a -> { b -> a + b } }(1))
    add33(Pair(3, 5))

    println("==========")
    println(compose22(::square, ::triple)(100))

}

val add33: (Pair<Int, Int>) -> Int = { pair -> pair.first + pair.second }


val add2: (Int) -> (Int) -> Int = { a -> { b -> a + b } }

fun add3(a: Int): (Int) -> Int = fun(b: Int): Int { return a + b }

fun add4(a: Int): (Int) -> Int {
    return fun(b: Int): Int {
        return a + b
    }
}

val map = mapOf("key" to "value")

val returnApplyN = { n: Int ->
    { f: (Int) -> Int ->
        f(n)
    }
}
val apply10 = returnApplyN(10)
val twenty = apply10({ it + it }) // 20
val twenty2 = apply10 { it + it } // 20
val twenty3 = returnApplyN(10)({ it + it })

//val twenty4Fail = returnApplyN(10) { it + it }
val twenty4Success = (returnApplyN(10)) { it + it }

val taxRate = 0.09
val addTax = { taxRate: Double -> { price: Double -> price + price * taxRate } }


fun addTax2(taxRate: Double): (Double) -> Double {
    return fun(price: Double): Double {
        return price + price * taxRate
    }
}

fun <A, B, C> partialA(a: A, f: (A) -> (B) -> C): (B) -> C = f(a)

val func: () -> Unit = {}

val f: (Double) -> Double = { Math.PI / 2 - it }
val sin: (Double) -> Double = Math::sin
//val cos: Double = compose5(f, sin)(2.0)

val compose6: ((Double) -> Double) -> ((Double) -> Double) -> ((Double) -> Double) -> (Double) -> Double = { x: (Double) -> Double ->
    { y: (Double) -> Double ->
        { z: (Double) -> Double ->
            {
                x(y(z(it)))
            }
        }
    }
}

val compose5: ((Double) -> (Double)) -> ((Double) -> (Double)) -> (Double) -> Double =
    { x: (Double) -> Double ->
        { y: (Double) -> Double ->
            { z ->
                x(y(z))
            }
        }
    }

val compose7 = { x: (Double) -> Double -> { y: (Double) -> Double -> { z: Double -> x(y(z)) } } }

val cosValue = compose7({ x: Double -> Math.PI / 2 - x })


val compose8: ((Int) -> Int) -> ((Int) -> Int) -> (Int) -> Int =
    { x: (Int) -> Int ->
        { y: (Int) -> Int ->
            { z: Int ->
                x(y(z))
            }
        }
    }

val compose22: ((Int) -> Int, (Int) -> Int) -> (Int) -> Int = { x, y ->
    {
        x(y(it))
    }
}
























