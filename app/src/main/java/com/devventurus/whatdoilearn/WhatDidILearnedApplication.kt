package com.devventurus.whatdoilearn

import android.app.Application
import com.devventurus.whatdoilearn.DI.LearnedItemModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WhatDidILearnedApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WhatDidILearnedApplication)
            modules(LearnedItemModule.module)
        }
    }
}