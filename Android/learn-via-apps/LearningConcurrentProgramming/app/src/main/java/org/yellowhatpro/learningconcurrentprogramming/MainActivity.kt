package org.yellowhatpro.learningconcurrentprogramming

import android.content.ContentValues.TAG
import android.os.*
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.yellowhatpro.learningconcurrentprogramming.ui.theme.LearningConcurrentProgrammingTheme
import kotlin.concurrent.thread


const val MESSAGE_KEY = "message_key"

class MainActivity : ComponentActivity() {

    private val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val bundle = msg.data
            val message = bundle?.getString(MESSAGE_KEY) ?: ""
            Log.d(TAG, "handleMessage: $message")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //Simple thread
        thread(start = true){
            doSomething()
        }
        setContent {
            LearningConcurrentProgrammingTheme {

            }
        }
    }
    //Run code using handler
    private fun runCodeHandler(){
        val runnable = object: Runnable{
            override fun run() {
                Log.d("Operation From Runnable","Executes at the last")
            }
        }
        //Posting the runnable object at the end of the current Thread's stack using post function
        val handler = Handler()
        handler.post(runnable)
        //Its as Easy as : Handler().post{Log.d("stuff")}
        handler.postDelayed(runnable,1000)
        handler.postAtTime(runnable, SystemClock.uptimeMillis()+400)
    }

    //Using Thread for background work stuff
    private fun runCodeInThread() {
        Thread {
            for (i in 1..10){
                Log.d(TAG, "runCodeInThread: $i")
            }
            Log.d(TAG, "runCodeInThread: All Done!")
        }.start()
        //or
        thread(start = true) {
            //same code

        }
    }
    //Can't access UI from Thread
    private fun sendingMessageFromThreadUsingMessage(){
        thread (start=true) {
            val bundle = Bundle()
            for (i in 1..10){
                bundle.putString(MESSAGE_KEY, "Message $i" )
                Message().also {
                    it.data = bundle
                    handler.sendMessage(it)
                }
            }
        }
    }

    //Finally coroutines
    private fun coroutinesStuff(){

    }
}


private fun doSomething() {
    TODO("Not yet implemented")
}
