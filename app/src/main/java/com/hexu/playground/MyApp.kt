package com.hexu.playground

import android.app.Application

class MyApp : Application() {

    val modules = listOf<InitModule>(FeedPrefetchModule())

    override fun onCreate() {
        super.onCreate()
        modules.forEach { it.onAppCreated(this) }
    }
}