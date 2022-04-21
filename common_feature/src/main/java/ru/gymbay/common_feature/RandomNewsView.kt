package ru.gymbay.common_feature

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class RandomNewsView(
    context: Context,
    attributeSet: AttributeSet
) : FrameLayout(context, attributeSet) {

    private val newsText: TextView?
        get() = findViewById(R.id.newsText)

    private val component: CommonFeatureComponent by lazy {
        DaggerCommonFeatureComponent
            .builder()
            .setDependencies(CommonFeatureDependenciesProvider.dependencies)
            .build()
    }

    private val scope = CoroutineScope(Dispatchers.IO)

    init {
        val newsRepository = component.newsRepository

        scope.launch {
            val newsList = newsRepository.get()

            withContext(Dispatchers.Main) {
                newsText?.text = newsList.first().title
            }
        }
    }

}