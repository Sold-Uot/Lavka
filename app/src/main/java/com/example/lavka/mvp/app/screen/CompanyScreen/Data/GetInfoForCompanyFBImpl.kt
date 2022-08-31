package com.example.lavka.mvp.app.screen.CompanyScreen.Data

import android.util.Log
import com.example.lavka.mvp.app.screen.CompanyScreen.domain.repository.GetInfoForCompanyFBReposytory
import com.google.firebase.database.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class GetInfoForCompanyFBImpl : GetInfoForCompanyFBReposytory {
    private lateinit var database: DatabaseReference
    private lateinit var myRef: DatabaseReference

        var text = ""
      override fun getInf() :String{
        database = FirebaseDatabase.getInstance().reference
        myRef = database.child("companyinf/")
        myRef.child("name").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                text=snapshot.getValue().toString()
                Log.e("CompanyFragment" ,snapshot.getValue().toString()+"1")


            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Company",error.toString()+"error")
            }
        })


        return text
    }
}