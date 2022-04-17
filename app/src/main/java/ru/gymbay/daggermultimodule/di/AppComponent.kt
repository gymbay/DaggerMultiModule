package ru.gymbay.daggermultimodule.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.gymbay.network.NetworkProvider
import javax.inject.Scope

@[AppScope Component(modules = [AppModule::class])]
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}

@Module
class AppModule {

    @[Provides AppScope]
    fun provideMoexService() = NetworkProvider().createMoexService()

}

@Scope
annotation class AppScope