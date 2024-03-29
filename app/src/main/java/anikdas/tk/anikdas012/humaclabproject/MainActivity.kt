package anikdas.tk.anikdas012.humaclabproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import anikdas.tk.anikdas012.humaclabproject.ui.LogInFragment

/**
 * Created by "Anik Das" on 10-Mar-2019
 * Developer email: "anikdas012@gmail.com"
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Adding Login fragment to the view
        supportFragmentManager.beginTransaction()
            .add(R.id.place_holder, LogInFragment(), "LogIn_Fragment")
            .commit()
    }
}
