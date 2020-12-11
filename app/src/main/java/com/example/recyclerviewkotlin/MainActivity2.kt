package com.example.recyclerviewkotlin

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main2.*
import java.net.URL


class MainActivity2: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if(intent.extras!=null){
            Glide.with(this).load(intent.getStringExtra("imagen")).into(imageView)
            textView6.text=intent.getStringExtra("nombre")
            textView7.text=intent.getStringExtra("apellidos")
            textView8.text=intent.getStringExtra("telefono")

        } else{
            finish()
        }
    }
}