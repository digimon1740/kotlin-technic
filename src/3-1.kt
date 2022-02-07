fun main() {
    { "Hello World!" }

    fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }
}

//
//class Dd {
//    fun square(n: Int) = n * n
//    fun triple(n: Int) = n * 3
//
//    fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }
//
//    val compose2: ((Int) -> Int, (Int) -> Int) -> (Int) -> Int = { x, y ->
//        {
//            x(y(it))
//        }
//    }
//
//    val compose3: ((Double) -> (Double), (Double) -> Double) -> (Double) -> Double = { x, y -> { x(y(it)) } }
//
//    val compose4: ((Int) -> Int, (Int) -> Int) -> (Int) -> Int = { x, y ->
//        { z ->
//            x(y(z))
//        }
//    }
//
//    fun <T, U, V> higherCompose() =
//        { f: (U) -> V ->
//            { g: (T) -> U ->
//                { x: T -> f(g(x)) }
//            }
//        }
//
//    fun <T, U, V> higherCompose2(): ((U) -> V) -> ((T) -> U) -> (T) -> V =
//        { f ->
//            { g ->
//                { x -> f(g(x)) }
//            }
//
//        }
//
//    fun cos(arg: Double) = compose3({ x: Double -> Math.PI / 2 - x }, Math::sin)(2.0)
//    fun test() {
//
//          val value = compose(::square, ::triple)
//
//
//        val cosValue: Double = compose3({ x: Double -> Math.PI / 2 - x }, Math::sin)(2.0)
//        val runnable = Runnable { println("This runs in a runnable") }
//
//
//    }
//}