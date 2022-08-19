package com.example.lavka.mvp.Helper

import com.example.lavka.mvp.model.ProductCartModel

class OrderStaticHelper {
   companion object{
       @JvmStatic
       var arrayList : ArrayList<ProductCartModel> =ArrayList<ProductCartModel>()
       var price: Int =0

   }
}