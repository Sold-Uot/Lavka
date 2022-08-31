package com.example.lavka.mvp.app.screen.CompanyScreen.di

import com.example.lavka.mvp.app.screen.CompanyScreen.Data.GetInfoForCompanyFBImpl
import com.example.lavka.mvp.app.screen.CompanyScreen.domain.GetInfoForFirebaseUseCase
import com.example.lavka.mvp.app.screen.CompanyScreen.domain.repository.GetInfoForCompanyFBReposytory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class CompanyModul {
    @Provides
    fun getReposytori():GetInfoForCompanyFBReposytory{
       return GetInfoForCompanyFBImpl()
    }
    @Provides
    fun getUsecase():GetInfoForFirebaseUseCase{
        return GetInfoForFirebaseUseCase(GetInfoForCompanyFBImpl())
    }
}