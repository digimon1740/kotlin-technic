import java.time.Instant

fun main(args: Array<String>) {
    val name: String by lazy { getName() }

    val list1 = listOf(1,2,3)
    val list2 = list1 + 4
    val list3 = list1 + list2

    list3.asSequence().map { it }.toCollection(ArrayList())

}

fun getName(): String {
    return "ddd"
}

class Person1 constructor(name: String) {
    val name: String

    init {
        this.name = name
    }
}

class Person2 constructor(name: String) {
    val name: String = name
}

class Person3 constructor(val name: String) {
}

class Person4(val name: String) {
}

class Person5(val name: String, val registered: Instant = Instant.now(), val list: List<String>) {


}