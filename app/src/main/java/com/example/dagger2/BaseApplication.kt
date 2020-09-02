package com.example.dagger2

import android.app.Application
import com.example.dagger2.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

open class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {


        return DaggerAppComponent.builder().Application(this).build()
    }

}