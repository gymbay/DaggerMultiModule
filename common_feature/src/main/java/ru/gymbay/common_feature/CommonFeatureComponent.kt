package ru.gymbay.common_feature

import androidx.annotation.RestrictTo
import dagger.Component
import ru.gymbay.core.annotations.Feature
import ru.gymbay.core.repositories.NewsRepository
import kotlin.properties.Delegates.notNull

@[Feature Component(dependencies = [CommonFeatureDependencies::class])]
internal interface CommonFeatureComponent {

    val newsRepository: NewsRepository

    @Component.Builder
    interface Builder {
        fun setDependencies(dependencies: CommonFeatureDependencies): Builder
        fun build(): CommonFeatureComponent
    }

}

interface CommonFeatureDependencies {
    val newsRepository: NewsRepository
}

internal interface CommonFeatureDependenciesProvider {
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val dependencies: CommonFeatureDependencies

    companion object : CommonFeatureDependenciesProvider by CommonFeatureDependenciesStore
}

object CommonFeatureDependenciesStore: CommonFeatureDependenciesProvider {
    override var dependencies: CommonFeatureDependencies by notNull()
}