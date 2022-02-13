tailrec fun factorial(n: Int, acc: Int): Int {
    return if (n <= 0) {
        acc
    } else {
        factorial(n - 1, n * acc)
    }
}

fun main() {
    println("recursion - factorial(10): ${factorial(10, 1)}")
}

