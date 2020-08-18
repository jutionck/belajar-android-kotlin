package com.example.first_android

import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    //for class dialog task
    //private lateinit var progressDialog: ProgressDialog
//    private val maxProgress: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        progressBar.max = maxProgress
        //for class dialog task
        //progressDialog = ProgressDialog(this)
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
    }

    fun startProgress(view: View) {
        val fetchDataTask = FetchDataTask()
        fetchDataTask.execute()

//        CoroutineScope(Dispatchers.Main).launch {
//            for (i in 1..100){
//                progressBar.progress = i
//                println(i)
//                delay(50)
//            }
//        }
        //val progressThread = ProgressThread(progressBar)
        //progressThread.start()
        //val progressTask = ProgressTask(progressBar)
        //progressTask.execute()
        //val progressDialogTask = ProgressDialogTask(progressDialog)
        //progressDialogTask.execute()

    }

}


