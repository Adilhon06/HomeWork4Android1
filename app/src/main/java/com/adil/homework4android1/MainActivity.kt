package com.adil.homework4android1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var text: TextView
    private lateinit var editText: EditText
    private lateinit var buttonToWhatsap: MaterialButton
    private lateinit var buttonToGallery: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = this.findViewById(R.id.tv_hint)
        buttonToWhatsap = this.findViewById(R.id.btn_go)
        image = this.findViewById(R.id.iv_whatsapp_icon)
        editText = this.findViewById(R.id.et_space_for_phone_number)

        goToWhatsapp()

    }

    private fun goToWhatsapp() {
        buttonToWhatsap.setOnClickListener {
            val phoneNumber = editText.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
            startActivity(intent)
        }
    }
}

