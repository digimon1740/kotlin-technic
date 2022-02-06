class Dd {
    fun square(n: Int) = n * n
    fun triple(n: Int) = n * 3

    fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }

    val compose2: ((Int) -> Int, (Int) -> Int) -> (Int) -> Int = { x, y ->
        {
            x(y(it))
        }
    }


    val compose3: ((Double) -> (Double), (Double) -> Double) -> (Double) -> Double = { x, y-> { x(y(it)) } }

    fun test() {

        val value = compose(::square, ::triple)
        val value2 = compose2(::square, ::triple)(1000)

        val cosValue: Double = compose3({ x: Double -> Math.PI / 2 - x }, Math::sin)(2.0)

    }

}