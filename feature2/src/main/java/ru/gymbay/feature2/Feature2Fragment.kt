package ru.gymbay.feature2

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import ru.gymbay.android.navigation.Feature2Route
import ru.gymbay.core.network.MoexService
import ru.gymbay.core.repositories.NewsRepository
import ru.gymbay.models.bond.Board
import ru.gymbay.utils.extensions.formatToString
import javax.inject.Inject

class Feature2Fragment : Fragment() {

    private var isin: String? = null

    private val isinText: TextView?
        get() = view?.findViewById(R.id.isin)

    private val news: TextView?
        get() = view?.findViewById(R.id.news)

    @Inject
    lateinit var moexService: MoexService

    @Inject
    lateinit var newsRepository: NewsRepository

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ViewModelProvider(this)
            .get<Feature2ComponentViewModel>()
            .feature2Component
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isin = it.getString(Feature2Route.ISIN)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feature2, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            if (isin == null) return@launchWhenCreated
            val history = moexService.getBondHistory(Board.TQCB, isin!!, "2022-02-11")
            val bondInfo = history.getOrNull(1)?.history?.firstOrNull()
            isinText?.text = "Bond short name is ${bondInfo?.shortName ?: "<Not found>"}"
        }

        lifecycleScope.launchWhenCreated {
            val newsList = newsRepository.get()
            news?.text = "${newsList.first().title}. \nUtil result: ${112332.33.formatToString()}"
        }
    }

}