package com.example.rokkha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.telephony.SmsManager
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class alert : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_LOCATION = 1
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val alertbutton = findViewById<Button>(R.id.buttonalert)
        alertbutton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MY_PERMISSIONS_REQUEST_LOCATION)
            } else {
                getLocationAndSend()
            }
        }
        val contact = findViewById<Button>(R.id.addcontact)
        contact.setOnClickListener {
            val intent = Intent(this, Helper::class.java)
            startActivity(intent)
        }
    }

    private fun getLocationAndSend() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    /*val message = "I am in danger!! Here's my location: https://www.google.com/maps/search/?api=1&query=${it.latitude},${it.longitude}"
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("smsto:${+8801990188461}") // Replace phoneNumber with the phone number of your contact
                        putExtra("sms_body", message)
                    }
                    startActivity(intent)*/
                    val message = "I am in danger!! Here's my location: https://www.google.com/maps/search/?api=1&query=${it.latitude},${it.longitude}"
                    val sms = this.getSystemService(SmsManager::class.java)
                    var dataBase: SqliteDatabase = SqliteDatabase(this)
                    val allContacts = dataBase.listContacts()
                    for (contact in allContacts){
                        sms.sendTextMessage("0"+contact.phno, "01732073478", message, null, null)
                    }

                }
            }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocationAndSend()
                }
            }
        }
    }






}