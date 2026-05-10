package com.example.dungeondelverapp

import android.app.Application
import android.content.Context
import com.example.dungeondelverapp.db.MyObjectBox
import io.objectbox.BoxStore

class MyApp : Application() {

    companion object {
        lateinit var appContext: Context
        lateinit var boxStore: BoxStore
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        boxStore = MyObjectBox.builder()
            .androidContext(this)
            .build()
    }
}