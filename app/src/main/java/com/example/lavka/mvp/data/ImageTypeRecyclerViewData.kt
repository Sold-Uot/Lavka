package com.example.lavka.mvp.data

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lavka.R
import com.example.lavka.mvp.Contract
import com.example.lavka.mvp.Helper.Helper
import com.example.lavka.mvp.Helper.OrderStaticHelper
import com.example.lavka.mvp.model.ImageTypeModel
import com.example.lavka.mvp.model.ProductCartModel
import com.google.firebase.database.*


 class ImageTypeRecyclerViewData : Contract.model {
     override fun ImageTypeArrayList(): ArrayList<ImageTypeModel> {
         var productsList : ArrayList<ImageTypeModel> = ArrayList()
         productsList!!.add(ImageTypeModel(1, R.drawable.moloko))
         productsList!!.add(ImageTypeModel(2, R.drawable.fruct))
         productsList!!.add(ImageTypeModel(3, R.drawable.ptica))
         productsList!!.add(ImageTypeModel(4, R.drawable.miso))
         productsList!!.add(ImageTypeModel(5, R.drawable.unknown))
         return productsList
     }


 }


