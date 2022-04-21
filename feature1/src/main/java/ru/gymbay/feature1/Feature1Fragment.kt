package ru.gymbay.feature1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import ru.gymbay.android.navigation.Feature2Route
import ru.gymbay.android.navigation.toFeatureRequest

class Feature1Fragment : Fragment() {

    private val button: Button?
        get() = view?.findViewById(R.id.toFeature2)

    private val editText: EditText?
        get() = view?.findViewById(R.id.isinText)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText?.setText("RU000A0JXPG2")

        button?.setOnClickListener {
            val enteredText = editText?.text.toString()

            val request = toFeatureRequest(Feature2Route(resources)) {
                isin = enteredText
            }
            findNavController().navigate(request)
        }
    }

}