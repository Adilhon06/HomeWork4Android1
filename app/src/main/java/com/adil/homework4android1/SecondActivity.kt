package com.adil.homework4android1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class SecondActivity : AppCompatActivity() {

    private lateinit var image: ImageView

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            image.setImageURI(uri)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        image = this.findViewById(R.id.iv_whatsapp_icon)

        changeIcon()
    }

    private fun changeIcon() {
        image.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        getContent.launch("image/*")
    }
}