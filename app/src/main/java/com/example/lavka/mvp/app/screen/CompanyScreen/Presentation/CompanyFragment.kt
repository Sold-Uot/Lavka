package com.example.lavka.mvp.app.screen.CompanyScreen.Presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.lavka.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompanyFragment : Fragment(R.layout.fragment_company) {

    private lateinit var viewModel : CompanyFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel  = ViewModelProvider(this).get(CompanyFragmentViewModel::class.java)


        viewModel.getInf()

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textview = view.findViewById<TextView>(R.id.teev)


        viewModel.liveData.observe(viewLifecycleOwner, Observer {

            textview.text = it

        })


    }



}
