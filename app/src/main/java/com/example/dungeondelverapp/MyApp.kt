package com.example.dungeondelverapp

import android.app.Application
import android.content.Context
import com.example.dungeondelverapp.db.MyObjectBox
import io.objectbox.BoxStore

class MyApp : Application() {

    companion object {
        lateinit var appContext: Context
        lateinit var store: BoxStore

        fun initDB() {
            store = MyObjectBox.builder()
                .androidContext(appContext)
                .build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        initDB()
    }
}