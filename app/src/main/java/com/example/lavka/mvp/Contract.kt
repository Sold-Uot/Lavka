package com.example.lavka.mvp

import android.content.Context
import android.view.View
import com.example.lavka.mvp.model.ImageTypeModel
import com.example.lavka.mvp.model.ProductCartModel
import com.google.firebase.ktx.Firebase

interface Contract {
    interface model {

        fun ImageTypeArrayList() : ArrayList<ImageTypeModel>? {
            return null
        }
    }
    interface preseter{
        fun onClickByButton(){}
        fun onSelectButtonNavBarP() {
    }
        fun setRecyclerFirebase(c: Context?, v: View?, string: String?){}
        fun addItemRecyclerView(c: Context?,v: View?){}
    }
    interface view{
        fun onStartButtomSheetFragment(){}
        fun setRecycler(datalist: List<ImageTypeModel?>?, c: Context?, v: View?){}

        fun onSelectButtonV(){}
        fun showFirebaseRecyclerView(c: Context?,v: View?,string: String?){}
    }

}