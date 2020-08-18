package com.example.first_android

import android.app.ProgressDialog
import android.os.AsyncTask
import android.widget.ProgressBar
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

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

class FetchDataTask: AsyncTask<String, Unit, Unit>() {

    override fun doInBackground(vararg params: String?) {

        val url = URL("http://10.0.2.2:9000/food")
        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "GET"
        val response = urlConnection.inputStream.bufferedReader().readText()
//        val url = URL("http://10.0.2.2:9000/food")
//        val stringResponse = url.readText()
//        println(stringResponse)
        println(response)
        val jsonArray = JSONArray(response)
        println(jsonArray.getJSONObject(0).getJSONObject("data").get("foodCode"))

    }

}