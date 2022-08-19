package com.example.lavka.mvp.app.screen

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lavka.R
import com.example.lavka.mvp.Contract

import com.example.lavka.mvp.presenter.Presenter
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), Contract.view {
    var TAG: String = "MainActivity"

    lateinit var buttonNav: BottomNavigationView
    lateinit var mPresenter: Contract.preseter




    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(R.layout.activity_main)
        mPresenter = Presenter(this)

        buttonNav = findViewById(R.id.ButtomNavBar)
        mPresenter.onSelectButtonNavBarP()




    }

    override fun onSelectButtonV() {
        super.onSelectButtonV()
        val navController : NavController =  findNavController(R.id.MianActivityContainer)

        buttonNav.setupWithNavController(navController)

    }




}
