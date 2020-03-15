package br.com.newton.appmax.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.newton.appmax.R
import br.com.redcode.easyglide.library.load
import kotlinx.android.synthetic.main.fragment_alvaras.*

/**
 * A simple [Fragment] subclass.
 */
class AlvarasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alvaras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageViewEmpty.load(R.drawable.maxima_empty_state)
    }


}
