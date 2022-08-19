package com.example.lavka.mvp.app.screen.BottomSheetGroupScreen.ConfirmationButtomSheetFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lavka.R
import com.example.lavka.mvp.model.ProductCartModel
import com.squareup.picasso.Picasso

class ConfirmationButtomSheetAdapter (var array: ArrayList<ProductCartModel>,var context: Context) : RecyclerView.Adapter<ConfirmationButtomSheetAdapter.ConfirmationButtomSheetViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConfirmationButtomSheetViewHolder {

        return ConfirmationButtomSheetViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.conf_basket_item,parent,false))
    }

    override fun onBindViewHolder(holder: ConfirmationButtomSheetViewHolder, position: Int) {
        var price = array?.get(position)?.price
        var name = array?.get(position)?.name
        holder.name.text = name
        holder.price.text = price.toString() + "₽"

        Picasso.with(context).load(array.get(position).imgres).into(holder.imageview)

    }

    override fun getItemCount(): Int {
        return array.size
    }
    class ConfirmationButtomSheetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.nameConfBasket)
        var price: TextView = itemView.findViewById(R.id.priceConfBasket)
        var imageview: ImageView = itemView.findViewById(R.id.imageViewConfBasket)
    }
}
