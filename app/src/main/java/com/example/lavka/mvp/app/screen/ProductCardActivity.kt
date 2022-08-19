package com.example.lavka.mvp.app.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.lavka.R
import com.example.lavka.mvp.Helper.OrderStaticHelper
import com.squareup.picasso.Picasso

class ProductCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_card)
        var textView :TextView = findViewById(R.id.textView)

        var botton :Button = findViewById(R.id.button)
        var image : ImageView = findViewById(R.id.imageView2)
        var name = intent.getStringExtra("name")
//        var price = intent.getIntExtra("price",1)
        var availability = intent.getStringExtra("ability")
        var imageres = intent.getStringExtra("image")
        var id = intent.getIntExtra("id1",12)
        var articul = intent.getIntExtra("articul1",11)

        textView.text = name
        Picasso.with(this).load(imageres).into(image)

        botton.setOnClickListener(View.OnClickListener {

            Log.e("ProductActivity", OrderStaticHelper.arrayList.toString())
        })





    }


}