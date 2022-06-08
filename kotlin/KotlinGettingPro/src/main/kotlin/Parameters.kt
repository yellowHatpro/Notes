fun main() {
    val array = intArrayOf(23,444,44)
    val max = getMaxUsingVarargs(1, 2, 3, *array, 5)
    println(max)
}

fun getMax(list: List<Int>): Int {
TODO()
}

//Varargs means we can have variable number of arguments
fun getMaxUsingVarargs(vararg numbers: Int): Int{
    var max = numbers[0]
    for (number in numbers ) {
        if (number > max ) {
            max = number
        }
    }
    return max
}