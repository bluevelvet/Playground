package com.hexu.playground

import android.app.Service
import android.content.Intent
import android.content.res.Configuration
import android.os.IBinder
import com.hexu.playground.aidl.IMyService

class MyService : Service() {

    private val binder: IMyService.Stub = object: IMyService.Stub() {
        override fun add(content: ByteArray?, type: Int) {
            println("duck, add log")
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("duck onBind")
        return binder
    }


    override fun onUnbind(intent: Intent?): Boolean {
        println("duck onUnbind")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        println("duck onRebind")
        super.onRebind(intent)
    }

    override fun onCreate() {
        println("kuaishou onCreate")
        super.onCreate()
    }

    override fun onDestroy() {
        println("duck onDestroy")
        super.onDestroy()
    }

    override fun stopService(name: Intent?): Boolean {
        println("duck stop service")
        return super.stopService(name)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        println("duck onConfigChanged")
        super.onConfigurationChanged(newConfig)
    }

    override fun onLowMemory() {
        println("duck onLowMemory")
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        println("duck onTrimMemory")
        super.onTrimMemory(level)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("duck, onStartCommand: $intent")
        return START_STICKY
    }
}