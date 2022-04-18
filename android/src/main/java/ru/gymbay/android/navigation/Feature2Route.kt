package ru.gymbay.android.navigation

import android.content.res.Resources
import androidx.core.net.toUri
import ru.gymbay.android.R

class Feature2Route(resources: Resources) : NavRoute(resources) {

    lateinit var isin: String

    override fun prepare() {
        var link = resources.getString(R.string.nav_key_feature2)
        link = link.putParameter(ISIN, isin)
        uriRoute = link.toUri()
    }

    companion object {
        const val ISIN = "isin"
    }

}