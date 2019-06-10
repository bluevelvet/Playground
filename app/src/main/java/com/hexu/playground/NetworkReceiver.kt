package com.hexu.playground

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

public class NetworkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("kuaishou", "Network changed: " + intent?.action);
    }
}