package com.example.lavka.mvp.app.screen.BottomSheetGroupScreen.ConfirmationButtomSheetFragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lavka.R
import com.example.lavka.mvp.Helper.OrderStaticHelper
import com.example.lavka.mvp.app.screen.BasketScreen.BasketFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class ConfirmationButtomSheetFragment : Fragment(R.layout.fragment_confirmation_buttom_sheet) {


    lateinit var recyclerView: RecyclerView
    lateinit var confirmationButtomSheetAdapter: ConfirmationButtomSheetAdapter
    lateinit var buttonConfirmation: Button

    lateinit var lastPrice: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.ConfrecyclerView)
        buttonConfirmation = view.findViewById(R.id.ConfButton)
        lastPrice = view.findViewById<TextView?>(R.id.lastPrice)
        val rx =BasketFragment.RxLoadBasketArray().subscribeOn(Schedulers.newThread())
           .observeOn(AndroidSchedulers.mainThread()).subscribe (
               {
                   recyclerView?.layoutManager = LinearLayoutManager(context)
                   confirmationButtomSheetAdapter = ConfirmationButtomSheetAdapter(it, requireContext())
                   recyclerView!!.adapter = confirmationButtomSheetAdapter
               },{},{})
        lastPrice.text = OrderStaticHelper.price.toString()


    }



}