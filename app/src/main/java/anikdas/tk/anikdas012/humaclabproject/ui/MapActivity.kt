package anikdas.tk.anikdas012.humaclabproject.ui

import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import anikdas.tk.anikdas012.humaclabproject.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker

/**
 * Created by "Anik Das" on 11-Mar-2019
 * Developer email: "anikdas012@gmail.com"
 */


class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var map: GoogleMap
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var requestCallback: LocationCallback
    lateinit var locationRequest: LocationRequest
    lateinit var locationManager: LocationManager
    var marker: Marker? = null
    lateinit var location: Location

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
                location = locationRequest!!.lastLocation
            }
        }
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager


//        Initialing view components
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    /**
     * This method will be called when map is ready
     */
    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!
        map.setMyLocationEnabled(true)
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
    }


    /**
     * This method will show user's current location
     */
    fun showCurrentLocation(location: Location) {
    }
}
