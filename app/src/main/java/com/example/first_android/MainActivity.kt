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
    private val maxProgress: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.max = maxProgress
        //for class dialog task
        //progressDialog = ProgressDialog(this)
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
    }

    fun startProgress(view: View) {

        CoroutineScope(Dispatchers.Main).launch {
            for (i in 1..100){
                progressBar.progress = i
                println(i)
                delay(50)
            }
        }
        //val progressThread = ProgressThread(progressBar)
        //progressThread.start()
        //val progressTask = ProgressTask(progressBar)
        //progressTask.execute()
        //val progressDialogTask = ProgressDialogTask(progressDialog)
        //progressDialogTask.execute()
    }

}

//Class thread
class ProgressThread(private var progressBar: ProgressBar): Thread() {

    override fun run() {
        for (i in 1..100){
            progressBar.progress = i
            Thread.sleep(200)
        }
    }
}

//Class AsyncTask
class  ProgressTask(private var progressBar: ProgressBar): AsyncTask<Unit, Unit, Unit>() {

    override fun doInBackground(vararg params: Unit?) {
        for (i in 1..100){
            progressBar.progress = i
            Thread.sleep(200)
        }
    }

}

//Class Dialog Task
class ProgressDialogTask(private var progressDialog: ProgressDialog): AsyncTask<String, Int, Unit>() {

    override fun onPreExecute() {
        progressDialog.show()
    }

    override fun doInBackground(vararg params: String?) {
        for (i in 1..100){
            Thread.sleep(200)
        }
    }

    override fun onPostExecute(result: Unit?) {
        progressDialog.dismiss()
    }
}
