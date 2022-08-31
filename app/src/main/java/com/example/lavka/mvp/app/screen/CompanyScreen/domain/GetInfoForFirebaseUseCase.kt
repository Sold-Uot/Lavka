package com.example.lavka.mvp.app.screen.CompanyScreen.domain

import android.util.Log
import com.example.lavka.mvp.app.screen.CompanyScreen.domain.repository.GetInfoForCompanyFBReposytory

class GetInfoForFirebaseUseCase(private var getInfoForCompanyFBReposytory: GetInfoForCompanyFBReposytory) {

    fun execute() : String {

        Log.e("Usecase", getInfoForCompanyFBReposytory.getInf())

        return getInfoForCompanyFBReposytory.getInf()
    }

}