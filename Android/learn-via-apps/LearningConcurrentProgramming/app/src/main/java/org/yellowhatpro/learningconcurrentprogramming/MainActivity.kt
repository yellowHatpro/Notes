package org.yellowhatpro.learningconcurrentprogramming

import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.yellowhatpro.learningconcurrentprogramming.ui.theme.LearningConcurrentProgrammingTheme
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
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

    private fun runCode(){
        val runnable = object: Runnable{
            override fun run() {
                Log.d("Operation From Runnable","Executes at the last")
            }
        }
        //Posting the runnable object at the end of the current Thread's stack using post function
        val handler = Handler()
        handler.post(runnable)
        handler.postDelayed(runnable,1000)
        handler.postAtTime(runnable, SystemClock.uptimeMillis()+400)
        //Its as Easy as : Handler().post{Log.d("stuff")}
    }
}


private fun doSomething() {
    TODO("Not yet implemented")
}
