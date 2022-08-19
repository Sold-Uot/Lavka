package com.example.lavka.mvp.app.screen.BottomSheetGroupScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lavka.R
import com.example.lavka.mvp.Contract
import com.example.lavka.mvp.presenter.Presenter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment




class ButtomSheetFragment : BottomSheetDialogFragment() ,Contract.view {

    val mPresenter : Presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_buttom_sheet, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }



}