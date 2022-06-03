//JvmStatic, JvmOverloads, and JvmField

object Utils{
    @JvmStatic
    fun doSomething(): String = "Executed"
}

class KotlinClass {
    val result: String = Utils.doSomething()
}

//In JAVA

public class JavaClass{
    String result = Utils.INSTANCE.doSomething(); //If not annotated with @JvmStatic
    String res = Utils.doSomething(); //If annotated with @JvmStatic
}

//If we dont want to use the INSTANCE keyword, we can annotate doSomething() with @JvmStatic

@JvmOverloads
data class Event (val name: String, @JvmField val date: Date = Date())

//No error
class KotlinClass {
    val eventOne = Event(name = "Ashu")
    val date = Date(Date().time.minus(24*60*60*1000L))
    val eventTwo = Event(name = "Ashu", date = date)
}


//TO use the default argument concept of Kotlin, we can annotate the constructor with @JvmOverloads
class JavaClass {
    Event event = new Event(name = "Ashu");
}

//JVMField

class KotlinClass {
    val eventOne = Event(name = "Ashu")
    val date = Date(Date().time.minus(24*60*60*1000L))
    val eventTwo = Event(name = "Ashu", date = date)

    //using date parameter from eventOne
    val date: Date = eventOne.date
}

//To be able to do the same in Java Class, we can annotate the constructor field with @JvmField, then in Java Class:

class JavaClass {
    Event event = new Event(name = "Ashu");
    Date date = event.date;//if annotated
    Date date = event.getDate();//if not annotated
}

