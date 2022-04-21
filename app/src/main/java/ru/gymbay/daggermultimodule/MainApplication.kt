package ru.gymbay.daggermultimodule

import android.app.Application
import ru.gymbay.common_feature.CommonFeatureDependenciesStore
import ru.gymbay.daggermultimodule.di.AppComponent
import ru.gymbay.daggermultimodule.di.DaggerAppComponent
import ru.gymbay.feature2.Feature2DependenciesStore

class MainApplication : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Feature2DependenciesStore.dependencies = appComponent
        CommonFeatureDependenciesStore.dependencies = appComponent
    }

}