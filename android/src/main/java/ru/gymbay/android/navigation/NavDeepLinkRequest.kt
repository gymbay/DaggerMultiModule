package ru.gymbay.android.navigation

import android.content.res.Resources
import android.net.Uri
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import ru.gymbay.android.R

class NavRoute(
    internal val resources: Resources
) {

    internal var uri: Uri? = null

    internal fun build(): NavDeepLinkRequest {
        check(uri != null) {
            "Route not initialized!"
        }

        return NavDeepLinkRequest.Builder
            .fromUri(uri!!)
            .build()
    }

}

fun toFeatureRequest(resources: Resources, route: NavRoute.() -> Unit): NavDeepLinkRequest =
    NavRoute(resources).apply(route).build()

fun NavRoute.navigateToFeature2(isin: String) {
    val link = resources.getString(R.string.nav_key_feature2)
    uri = link.replace("{isin}", isin).toUri()
}

