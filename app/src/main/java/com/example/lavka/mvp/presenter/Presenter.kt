package com.example.lavka.mvp.presenter

import android.content.Context

import android.view.View
import com.example.lavka.mvp.Contract
import com.example.lavka.mvp.data.ImageTypeRecyclerViewData
import com.example.lavka.mvp.model.ProductCartModel
import kotlinx.coroutines.runBlocking

class Presenter : Contract.preseter {
    private var mView: Contract.view
    private var mModel: ImageTypeRecyclerViewData


    private val TAG: String = "Presenter"
    private var array: ArrayList<ProductCartModel> = ArrayList()


    constructor(mView: Contract.view) {
        this.mView = mView

        this.mModel = ImageTypeRecyclerViewData()
    }


    override fun onSelectButtonNavBarP() {
        super.onSelectButtonNavBarP()
        mView.onSelectButtonV()
    }

    override fun setRecyclerFirebase(context: Context?, view: View?, string: String?): Unit = runBlocking {



        mView.showFirebaseRecyclerView(context, view, string)


    }


    override fun addItemRecyclerView(c: Context?, v: View?) {

        mView.setRecycler(mModel.ImageTypeArrayList(), c, v)

    }

    override fun onClickByButton() {
       mView.onStartButtomSheetFragment()

    }
}



