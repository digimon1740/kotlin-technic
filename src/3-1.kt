data class Price(private val value: Double) {
    override fun toString() = value.toString()
    operator fun plus(price: Price) = Price(this.value + price.value)
    operator fun times(num: Int) = Price(this.value * num)

    companion object {
        val identity = Price(0.0)
        operator fun invoke(value: Double) =
            if (value > 0)
                Price(value)
            else
                throw IllegalArgumentException("Price must be positive or null")
    }
}

data class Weight(val value: Double) {
    operator fun plus(weight: Weight) = Weight(this.value + weight.value)
    operator fun times(num: Int) = Weight(this.value * num)

    companion object {
        val identity = Weight(0.0)
        operator fun invoke(value: Double) =
            if (value > 0)
                Weight(value)
            else
                throw IllegalArgumentException("Weight must be positive or null")
    }
}

data class OrderLine(val product: Product, val count: Int) {
    fun weight(): Weight = product.weight * count
    fun amount() = product.price * count
}

data class Product(val name: String, val price: Price, val weight: Weight)

object Store {
    @JvmStatic
    fun main(args: Array<String>) {
        val toothPaste = Product("Tooth paste", Price(1.5), Weight(0.5))
        val toothBrush = Product("Tooth brush", Price(3.5), Weight(0.3))
        val orderLines = listOf(
            OrderLine(toothPaste, 2),
            OrderLine(toothBrush, 3)
        )
        val weight: Weight =
            orderLines.fold(Weight.identity) { a, b -> a + b.weight() }
        val price: Price =
            orderLines.fold(Price.identity) { a, b -> a + b.amount() }
        println("Total price: $price")
        println("Total weight: $weight")
    }

}
//class TestF {
//
//
//    val addTax = { taxRate: Double ->
//        var taxRate = 0.09
//        { price: Double ->
//            taxRate++
//            price + price
//        }
//    }
//
//}
//}
//
//fun a() {
//    var rate = 1;
//    fun b() {
//       rate++
//    }
//}
//fun main() {
//    addTax5(taxRate)(12.0)
//}


//fun main() {
//    val runnable = Runnable { }

//fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }
//}

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