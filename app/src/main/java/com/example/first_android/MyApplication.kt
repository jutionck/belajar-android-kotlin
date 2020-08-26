package com.example.first_android

import android.app.Application
import com.example.first_android.container.AppContainer

class MyApplication : Application() {

    val appContainer: AppContainer =
        AppContainer()
}