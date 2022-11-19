//Lamba function

//We created a lambda function with type parameter <X> which can be used with any List of items
//Example given below

fun <X> List<X>.customFilter(filterFunction: (X)  -> Boolean): List<X>{
    val resultList = mutableListOf<X>()
    for (item in this) // this is List<X> we apply extension function on
    {
        if (filterFunction(item)){
            resultList.add(item)
        }
    }
    return resultList
}

fun main() {
    var list = listOf(1,2,3,4,5)
  list =  list.customFilter {int->
        int%2==0
    }
    println(list)

    val list2 = ('a'..'z').toList().customFilter {char->
        char == 'a'  ||  char == 'b'
    }
    println(list2)
}

//However, we can restrain type parameter by using generic type parameter:
fun <X:Number> List<X>.customFilterWithGeneric(filterFunction: (X)  -> Boolean): List<X>{
    //Function now restricted to using Numbers only
    val resultList = mutableListOf<X>()
    for (item in this) // this is List<X> we apply extension function on
    {
        if (filterFunction(item)){
            resultList.add(item)
        }
    }
    return resultList
}
