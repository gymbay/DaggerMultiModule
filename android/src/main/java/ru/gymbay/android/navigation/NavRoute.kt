package ru.gymbay.android.navigation

import android.content.res.Resources
import android.net.Uri
import androidx.annotation.StringRes
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import ru.gymbay.android.R

abstract class NavRoute(
    internal val resources: Resources
) {

    internal lateinit var uriRoute: Uri

    internal fun <T> String.putParameter(name: String, value: T): String =
        this.replace("{$name}", value.toString())

    protected abstract fun prepare()

    internal fun build(): NavDeepLinkRequest {
        prepare()

        return NavDeepLinkRequest.Builder
            .fromUri(uriRoute)
            .build()
    }

}

fun <T : NavRoute> toFeatureRequest(route: T, config: T.() -> Unit) = route.apply(config).build()

