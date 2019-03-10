package anikdas.tk.anikdas012.humaclabproject.ui


import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

import anikdas.tk.anikdas012.humaclabproject.R
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

/**
 * Created by "Anik Das" on 10-Mar-2019
 * Developer email: "anikdas012@gmail.com"
 */

class LogInFragment : Fragment() {

    lateinit var tvUserName: AppCompatEditText
    lateinit var tvPassword: AppCompatEditText
    lateinit var btLogIn: AppCompatButton
    lateinit var progressBar: ProgressBar
    lateinit var  mRequest: RequestQueue

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
        progressBar = view.findViewById(R.id.progress_bar)
        val tvWarning: AppCompatTextView = view.findViewById(R.id.warning_text)

//        Adding click listener to button
        btLogIn.setOnClickListener {
            if (tvUserName.text!!.isNotEmpty() && tvPassword.text!!.isNotEmpty()) {
                tvWarning.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
                logIn()
            } else {
                tvWarning.visibility = View.VISIBLE
            }
        }

//        New request queue of volley
        mRequest = Volley.newRequestQueue(context)
        mRequest.start()

        return view
    }


    /**
     * This function handles log in.
     * After successful login it starts
     * a new fragment to show current location.
     */
    private fun logIn() {
//        Basic atuh of user credential
        val userCredential = "${tvUserName.text} : ${tvPassword.text}"
        val basicAuth = "Basic ${Base64.encodeToString(userCredential.toByteArray(), Base64.DEFAULT)}"

//        Api url
        val url = "http://test.selliscope.com/api/v1/login"
    }


}
