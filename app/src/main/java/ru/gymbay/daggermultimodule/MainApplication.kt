package ru.gymbay.daggermultimodule

import android.app.Application
import ru.gymbay.daggermultimodule.di.AppComponent
import ru.gymbay.daggermultimodule.di.DaggerAppComponent

class MainApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}