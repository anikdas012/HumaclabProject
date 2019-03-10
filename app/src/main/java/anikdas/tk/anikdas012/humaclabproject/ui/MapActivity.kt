package anikdas.tk.anikdas012.humaclabproject.ui

import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import anikdas.tk.anikdas012.humaclabproject.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback

/**
 * Created by "Anik Das" on 11-Mar-2019
 * Developer email: "anikdas012@gmail.com"
 */


class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var map: MapView
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var requestCallback: LocationCallback
    lateinit var locationRequest: LocationRequest
    lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

//        Making location request
//        Adding location services
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(applicationContext)
//        Creating new location request object
        locationRequest = LocationRequest()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 10000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        Creating call back method for location services
        requestCallback = object : LocationCallback() {
            override fun onLocationResult(locationRequest: LocationResult?) {
                super.onLocationResult(locationRequest)
                val location = locationRequest!!.lastLocation
            }
        }
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager


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
