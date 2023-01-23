package com.matheusxreis.kotlinflow.bindingadapters

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView
import com.matheusxreis.kotlinflow.R

class MessageBindingAdapter {

    companion object {

        @BindingAdapter("isMessageMine")
        @JvmStatic
        fun isMessageMine(view: View, from:String){
            if(from === "me"){
                when(view){
                    is MaterialCardView -> {
                        view.setCardBackgroundColor(
                            ContextCompat.getColor(view.context, R.color.teal_700)
                        )
                    }
                }
            }
        }
    }

}