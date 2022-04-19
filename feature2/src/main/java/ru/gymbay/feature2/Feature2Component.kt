package ru.gymbay.feature2

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import dagger.Component
import ru.gymbay.core.network.Feature
import ru.gymbay.core.network.MoexService
import kotlin.properties.Delegates.notNull

@[Feature Component(dependencies = [Feature2Dependencies::class])]
internal interface Feature2Component {

    fun inject(fragment: Feature2Fragment)

    @Component.Builder
    interface Builder {
        fun setDependencies(dependencies: Feature2Dependencies): Builder
        fun build(): Feature2Component
    }

}

interface Feature2Dependencies {
    val moexService: MoexService
}

internal interface Feature2DependenciesProvider {
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val dependencies: Feature2Dependencies

    companion object : Feature2DependenciesProvider by Feature2DependenciesStore
}

object Feature2DependenciesStore : Feature2DependenciesProvider {
    override var dependencies: Feature2Dependencies by notNull()
}

internal class Feature2ComponentViewModel : ViewModel() {
    val feature2Component =
        DaggerFeature2Component
            .builder()
            .setDependencies(Feature2DependenciesProvider.dependencies)
            .build()
}