package com.hexu.playground

import android.content.*
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import com.hexu.playground.aidl.IMyService

class MainActivity : AppCompatActivity() {

    private val conn1: MyConnection = MyConnection("first_conn")
    private val conn2: MyConnection = MyConnection("second_conn")
    private lateinit var servceIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        servceIntent = Intent(this, MyService::class.java)
        startService(servceIntent)
        bindService(servceIntent, conn1, Context.BIND_AUTO_CREATE)
        bindService(servceIntent, conn2,  Context.BIND_AUTO_CREATE)
    }

    override fun onResume() {
        super.onResume()
        conn1.service?.add(ByteArray(0), 0)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        println("duck activity onTrimMemory $level")
        unbindService(conn1)
        unbindService(conn2)
    }
}

class MyConnection(val serviceName: String): ServiceConnection {

    var service: IMyService? = null

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        this.service = IMyService.Stub.asInterface(service)
        println("duck, service connected $serviceName")
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        this.service = null
        println("duck, service disconnected $serviceName")
    }
}
