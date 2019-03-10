package anikdas.tk.anikdas012.humaclabproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import anikdas.tk.anikdas012.humaclabproject.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback

/**
 * Created by "Anik Das" on 11-Mar-2019
 * Developer email: "anikdas012@gmail.com"
 */


class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

//        Initialing view components
        map = findViewById(R.id.map)
        map.getMapAsync(this)
    }


    /**
     * This method will be called when map is ready
     */
    override fun onMapReady(googleMap: GoogleMap?) {

    }
}
