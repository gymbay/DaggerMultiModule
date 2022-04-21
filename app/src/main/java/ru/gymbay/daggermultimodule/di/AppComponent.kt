package ru.gymbay.daggermultimodule.di

import android.app.Application
import dagger.*
import ru.gymbay.common_feature.CommonFeatureDependencies
import ru.gymbay.core.repositories.NewsRepository
import ru.gymbay.feature2.Feature2Dependencies
import ru.gymbay.network.NetworkProvider
import ru.gymbay.repositories.NewsRepositoryImpl
import javax.inject.Scope

@[AppScope Component(modules = [NetworkModule::class, RepositoriesModule::class])]
interface AppComponent:
    Feature2Dependencies,
    CommonFeatureDependencies
{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}

@Module
class NetworkModule {
    @[Provides AppScope]
    fun provideMoexService() = NetworkProvider().createMoexService()
}

@Module
interface RepositoriesModule {
    @Binds
    fun bindNewsRepositoryImplToNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}

@Scope
annotation class AppScope