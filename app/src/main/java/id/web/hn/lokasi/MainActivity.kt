package id.web.hn.lokasi

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var fusedLocationClient: FusedLocationProviderClient
    private val LOCATION_PERMISSION = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        btn_lokasi.setOnClickListener {
            cekLokasi()
        }
    }

    private fun cekLokasi() {

        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        if(permission != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_PERMISSION)

        } else {
            getLokasi()
        }



    }

    fun getLokasi(){
        fusedLocationClient.lastLocation
                .addOnSuccessListener {
                    val lat = it?.latitude
                    val lng = it?.longitude
                    Toast.makeText(this, "lat: $lat, long: $lng", Toast.LENGTH_SHORT).show()
                }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            LOCATION_PERMISSION -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "yeay", Toast.LENGTH_SHORT).show()
                getLokasi()
            }
            else -> Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show()
        }

    }
}
