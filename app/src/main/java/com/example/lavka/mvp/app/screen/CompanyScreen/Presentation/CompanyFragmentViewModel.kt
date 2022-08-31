package com.example.lavka.mvp.app.screen.CompanyScreen.Presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lavka.mvp.app.screen.CompanyScreen.Data.GetInfoForCompanyFBImpl
import com.example.lavka.mvp.app.screen.CompanyScreen.domain.GetInfoForFirebaseUseCase
import com.example.lavka.mvp.app.screen.CompanyScreen.domain.repository.GetInfoForCompanyFBReposytory
import com.example.lavka.mvp.model.ProductCartModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyFragmentViewModel @Inject constructor(private  var getInfoForCompanyUseCase: GetInfoForFirebaseUseCase) : ViewModel() {
    private val mutableLiveData: MutableLiveData<String> = MutableLiveData()
    val liveData: LiveData<String> = mutableLiveData


    fun getInf() {


        viewModelScope.launch {  val string = getInfoForCompanyUseCase.execute()
            mutableLiveData.value = string
        }


    }


}