package com.example.KeluargaKu

import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.*
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.util.*

class MapsActivity : Fragment(), OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {
//    private var fragment: Fragment? = null
    private lateinit var mMap: GoogleMap

    companion object {
        private val MY_PERMISSION_FINE_LOCATION = 101
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.about,
            container, false
        )
        val mapFragment = parentFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val pekanbaru = LatLng(0.53333, 101.45)
        mMap.addMarker(
            MarkerOptions().position(pekanbaru)
                .title("Marker di Kota Pekanbaru")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pekanbaru, 12F))
        mMap.uiSettings.isZoomControlsEnabled = true

        if (checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
        }
        mMap.setOnMarkerClickListener(this)
        tambahMarkerLongClick(mMap)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_tampilan_map, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.map_normal -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                true
            }
            R.id.map_hybrid -> {
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                true
            }
            R.id.map_satelit -> {
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                true
            }
            R.id.map_terrain -> {
                mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onMarkerClick(p0: Marker) = false

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSION_FINE_LOCATION -> if (grantResults[0] ==
                PackageManager.PERMISSION_GRANTED
            ) {
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                    } != PackageManager.PERMISSION_GRANTED &&
                    context?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    } != PackageManager.PERMISSION_GRANTED) {
                    mMap.isBuildingsEnabled = true
                }
            } else {
                Toast.makeText(activity,"\"Aplikasi ini membutuhkan izin akses lokasi\"",Toast.LENGTH_SHORT).show()
                activity?.finish()
            }
        }
    }

    private fun getAlamat(lat: LatLng): String? {
        val geocoder = activity?.let { Geocoder(it, Locale.getDefault()) }
        val list = geocoder?.getFromLocation(lat.latitude, lat.longitude, 1)
        return list?.get(0)?.getAddressLine(0)
    }

    fun tambahMarkerLongClick(googleMap: GoogleMap) {
        googleMap.setOnMapLongClickListener { latLng ->

            val koordinat = LatLng(latLng.latitude, latLng.longitude)
            val markerOptions = MarkerOptions().position(koordinat)
            val namaJalan = getAlamat(koordinat)
            markerOptions.title(namaJalan)

            googleMap.addMarker(
                MarkerOptions().position(koordinat).title("Marker Baru").snippet(namaJalan)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
            )
        }
    }
}




