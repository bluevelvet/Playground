package com.hexu.playground

import android.app.Application

public interface InitModule {

    fun onAppCreated(app: Application): Unit
}