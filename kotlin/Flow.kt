/*Flow is a Kotlin language feature that serves as a reactive programming framework.
 *Reactive Programming: It's about being notified about cany hanges in the code and doing something about it.
 *Flow is a Kotlin coroutine that can emit multiple values over a period of time.
 */


//Here we talk about Cold Flow
//Example of a ViewModel

class MainViewModel : ViewModel() {
    //flow is the flow builder
    //Inside the block is the FlowCollector<Int>
    val countDownFlow = flow<Int> { flowCollector ->
        //Inside this we can emit values over time
        //We can execute suspend fun inside the flow
        val startingValue = 10
        var currentValue = startingValue
        emit(startingValue) //10
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue) // 9 wait a sec, 8 wait a sec, 7 wait a sec, 6 wait a sec, 5 wait a sec, 4 wait a sec, 3 wait a sec, 2 wait a sec, 1 wait a sec, 0
        }
        
    }
}

class MainActivity : ComponentActivity() {
    // --
    setContent {
        val viewModel = viewModel<MainViewModel>()
        // We will get the flow as state
        val time = viewModel.countDownFlow.collectAsState(initial = 10)
        Box{
            Text {
                text = time.value.toString()
            }
        }
    }
}

//In above example we actually collected flow in the UI layer which we should not do, So we should update the ViewModel implementation

class MainViewModel : ViewModel() {
//--

init {
    collectFlow()
}

private fun collectFlow() {
    viewModelScope.launch {
        countDownFlow.collect { time ->
               //Update the UI
            println("Time is $time")
        }

        //collectLatest
        countDownFlow.collectLatest {
            //Update the UI
            delay(1500L)
            println("Time is $it")
            //We will get 0 at the end, since delay was longer than the emission of new values, the block cancels the flow
        }
    }
}
}

//Rest in android notes