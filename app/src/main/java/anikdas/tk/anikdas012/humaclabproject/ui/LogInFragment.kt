package anikdas.tk.anikdas012.humaclabproject.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

import anikdas.tk.anikdas012.humaclabproject.R

/**
 * Created by "Anik Das" on 10-Mar-2019
 * Developer email: "anikdas012@gmail.com"
 */

class LogInFragment : Fragment() {

    lateinit var tvUserName: AppCompatEditText
    lateinit var tvPassword: AppCompatEditText
    lateinit var btLogIn: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)

//        Initializing views
        tvUserName = view.findViewById(R.id.user_name)
        tvPassword = view.findViewById(R.id.password)
        btLogIn = view.findViewById(R.id.log_in)

        return view
    }


}
