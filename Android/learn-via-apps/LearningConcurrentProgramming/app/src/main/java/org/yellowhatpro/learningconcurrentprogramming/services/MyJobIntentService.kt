package org.yellowhatpro.learningconcurrentprogramming.services

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService

/*
This Service needs to permission "android.permission.BIND_JOB_SERVICE"
 */

// Every JobIntentService requires a job id
const val JOB_ID = 1101

class MyJobIntentService : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        TODO("Not yet implemented")
    }

    companion object{
        fun startActionFoo(context: Context, param1:String, param2: String){
            val intent = Intent(context,MyJobIntentService::class.java).apply {
                action = "ACTION"
                putExtra("SOME_PARAM", param1)
                putExtra("SOME_PARAM", param2)
            }
            enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent)
        }
    }

}