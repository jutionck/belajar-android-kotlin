package com.example.first_android
import kotlinx.coroutines.*

fun main() {

    runBlocking { // start main coroutine
        println("Start")
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(2000)
            println("new Coroutine!")
        }
        println("Stop,") // main coroutine continues here immediately
        delay(3000)      // delaying for 2 seconds to keep JVM alive
    }
}

class CustomThread(var interval: Long): Thread() {
    override fun run() {
        for (i in 1..20) {
            sleep(interval)
            println("${Thread.currentThread().name} $i")
        }
    }
}