import kotlin.test.assertEquals

class Payment(val creditCard: CreditCard, val amount: Int) {
    fun combine(payment: Payment): Payment =
        if (creditCard == payment.creditCard) {
            Payment(creditCard, amount + payment.amout)
        } else {
            throw IllegalStateException("Cards don't match")
        }

    companion object {
        fun groupByCard(payments: List<Payment>): List<Payment> =
            payments.groupBy { it.creditCard }
                .values
                .map { it.reduce(Payment::combine) }
    }
}

class Purchase(val donuts: List<Donut>, val payment: Payment)

fun buyDonuts(quantity: Int = 1, creditCard: CreditCard): Purchase =
    Purchase(List(quantity) {
        Donut()
    }, Payment(creditCard, Donut.price * quantity))


class DonutShopKtTest {

    @Test
    fun testBuyDonuts() {
        val creditCard = CreditCard()
        val purchase = buyDonuts(5, creditCard)
        assertEquals(Donut.price * 5, purchase.payment.amount)
        assertEquals(creditCard, purchase.payment.creditCard)
    }

}

class Person(val name: String, val age: Int = 10)

fun main() {
    val list = List(2) {
        Person("ddd")
    }


    val a1: Map<String, Person> = list.associateBy { it.name }
    val a2: Map<Int, String> = list.associate { it.age to it.name }
    val a3: Map<Person, String> = list.associateWith { it.name }
}

