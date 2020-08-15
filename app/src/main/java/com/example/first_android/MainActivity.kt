package com.example.first_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_android.view_model.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val languageViewModel by viewModels<LanguageViewModel>()
    private lateinit var languageRecycleAdapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycle_view.layoutManager = LinearLayoutManager(this)
        //language_recycle_view.adapter = LanguageRecycleAdapter(languageViewModel.languageLiveData.value!!)
        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languageLiveData.value!!)
        language_recycle_view.adapter = languageRecycleAdapter
        languageViewModel.languageLiveData.observe(this, Observer {
            languageRecycleAdapter.notifyDataSetChanged()
        })
    }

    fun addLanguage(view: View) {
        val languageName = language_name_input.text.toString()
        languageViewModel.addLanguage(languageName)
    }
}