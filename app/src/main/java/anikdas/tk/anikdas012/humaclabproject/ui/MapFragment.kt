package anikdas.tk.anikdas012.humaclabproject.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import anikdas.tk.anikdas012.humaclabproject.R

/**
 * Created by "Anik Das" on 11-Mar-2019
 * Developer email: "anikdas012@gmail.com"
 */


class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }


}
