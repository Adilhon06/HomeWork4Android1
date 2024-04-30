package com.adil.homework4android1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var editTextWhatsapp: EditText
    private lateinit var editTextGoogle: EditText
    private lateinit var editTextYoutube: EditText
    private lateinit var buttonToWhatsapp: MaterialButton
    private lateinit var buttonToGoogle: MaterialButton
    private lateinit var buttonToYoutube: MaterialButton
    private lateinit var buttonToSecondActivity: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToWhatsapp = this.findViewById(R.id.btn_go)
        buttonToGoogle = this.findViewById(R.id.btn_go_to_google)
        buttonToYoutube = this.findViewById(R.id.btn_go_to_youtube)
        editTextWhatsapp = this.findViewById(R.id.et_space_for_phone_number)
        editTextYoutube = this.findViewById(R.id.et_find_on_youtube)
        editTextGoogle = this.findViewById(R.id.et_find_on_google)
        buttonToSecondActivity = this.findViewById(R.id.go_to_second_activity)

        goToWhatsapp()
        goToGoogle()
        goToYoutube()
        goToSecondActivity()
    }

    private fun goToWhatsapp() {
        buttonToWhatsapp.setOnClickListener {
            val phoneNumber = editTextWhatsapp.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
            startActivity(intent)
        }
    }

    private fun goToGoogle() {
        buttonToGoogle.setOnClickListener {
            val search = editTextGoogle.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/search?q=$search")
            startActivity(intent)
        }
    }

    private fun goToYoutube() {
        buttonToYoutube.setOnClickListener{
            val search = editTextYoutube.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.youtube.com/results?search_query=$search")
            startActivity(intent)
        }
    }

    private fun goToSecondActivity() {
        buttonToSecondActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}