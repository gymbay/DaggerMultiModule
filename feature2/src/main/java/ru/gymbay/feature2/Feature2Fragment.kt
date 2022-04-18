package ru.gymbay.feature2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.gymbay.android.navigation.Feature2Route

/**
 * A simple [Fragment] subclass.
 * Use the [Feature2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Feature2Fragment : Fragment() {

    private var isin: String? = null

    private val isinText: TextView?
        get() = view?.findViewById(R.id.isin)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isinText?.text = "My isin $isin"
    }

}