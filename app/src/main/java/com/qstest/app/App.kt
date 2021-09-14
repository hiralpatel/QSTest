package com.qstest.app

import android.app.Application
import android.content.Context
import com.qstest.di.productAPIModule
import com.qstest.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    companion object {
        var appContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        //Initialize the Koin for Dependency Injection
//        startKoin {
//            androidLogger(Level.DEBUG)
//            androidContext(this@App)
//            modules(
//                listOf(
//                )
//            )
//        }
//        productAPIModule,
//        retrofitModule
    }
}