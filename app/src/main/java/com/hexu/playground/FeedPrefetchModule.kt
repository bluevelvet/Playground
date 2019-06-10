package com.hexu.playground

import android.app.Application
import android.util.Log

public class FeedPrefetchModule: InitModule {

    override fun onAppCreated(app: Application) {
        Log.d("kuaishou", "Fetch Feed.")
    }
}