package com.example.swifty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class InfosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = ""

        val headingSwift : TextView = findViewById(R.id.heading)
        val mainSwift : TextView = findViewById(R.id.infos)

        val bundle : Bundle?= intent.extras
        val heading = bundle!!.getString("heading")
        val infos = bundle.getString("infos")

        headingSwift.text = heading
        mainSwift.text = infos

    }
}