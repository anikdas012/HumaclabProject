package anikdas.tk.anikdas012.humaclabproject.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import anikdas.tk.anikdas012.humaclabproject.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng

/**
 * Created by "Anik Das" on 11-Mar-2019
 * Developer email: "anikdas012@gmail.com"
 */


class MapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener {

    val LOG_TAG = "Map_Activity"
    lateinit var map: GoogleMap
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var requestCallback: LocationCallback
    lateinit var locationRequest: LocationRequest
    lateinit var locationManager: LocationManager
    var location: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

//        Making location request
//        Adding location services
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(applicationContext)
//        Creating new location request object
        locationRequest = LocationRequest()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 1000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        Creating call back method for location services
        requestCallback = object : LocationCallback() {
            override fun onLocationResult(locationRequest: LocationResult?) {
                super.onLocationResult(locationRequest)
                Log.d(LOG_TAG, "onLocationResult")
                location = locationRequest!!.lastLocation

//                Moving camera
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(location!!.latitude, location!!.longitude), 12.0f))
            }
        }
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager


//        Initialing view components
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        Log.d(LOG_TAG, "onRequestPermissionResult")
        if (requestCode == 10) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                map.isMyLocationEnabled = true
                map.setOnMyLocationButtonClickListener(this)
            }
        }
    }


    /**
     * This method will be called when map is ready
     */
    override fun onMapReady(googleMap: GoogleMap?) {
        Log.d(LOG_TAG, "onMapReady")
        map = googleMap!!
        map.mapType = GoogleMap.MAP_TYPE_NORMAL

//        Adding permission check
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //                Checking permission of gps
                requestPermissions( arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET
                ), 10)
                return
            }
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
            (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            map.isMyLocationEnabled = true
            map.setOnMyLocationButtonClickListener(this)
        }

//        Fixing BD on map
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(23.777681, 90.398005), 7.0f))
    }


    override fun onMyLocationButtonClick(): Boolean {
        Log.d(LOG_TAG, "onMyLocationButtonClick")

//        Moving camera
        if (location != null) {
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(location!!.latitude, location!!.longitude), 12.0f))
        }
        return false
    }
}
