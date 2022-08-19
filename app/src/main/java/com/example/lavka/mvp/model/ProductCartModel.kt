package com.example.lavka.mvp.model

import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatCheckBox

data class ProductCartModel(
    var name: String? = "",
    var articul: Int? = 0,
    var availability: Boolean? = false,
    var id: Int? = 0,
    var imgres: String? = "",
    var price: Int? = 0,
    var measurement_system: String? = ""
)
