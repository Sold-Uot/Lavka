package com.example.lavka.mvp.app.screen.ProductScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lavka.R
import com.example.lavka.mvp.model.ImageTypeModel

class ImageTypeAdapter(var discountedProductsList: List<ImageTypeModel?>) :
    RecyclerView.Adapter<ImageTypeAdapter.ImageTypeViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ImageTypeViewHolder {

        return ImageTypeViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_rv_view_type,p0,false))
    }
    override fun onBindViewHolder(parent: ImageTypeViewHolder, p1: Int) {
       parent.TypeDivanImageView.setImageResource(discountedProductsList?.get(p1)!!.imgeurl)
    }
    override fun getItemCount(): Int {

        return discountedProductsList!!.size
    }
class ImageTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var TypeDivanImageView: ImageView = itemView.findViewById(R.id.imgType)
}}
