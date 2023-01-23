package com.matheusxreis.kotlinflow.bindingadapters

import android.app.ActionBar.LayoutParams
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
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

                        val params = view.layoutParams as ConstraintLayout.LayoutParams
                        params.horizontalBias = 1f
                        view.layoutParams = params
                        view.setCardBackgroundColor(
                            ContextCompat.getColor(view.context, R.color.teal_700)
                        )

                    }
                    is TextView -> {
                        val params = view.layoutParams as ConstraintLayout.LayoutParams
                        params.horizontalBias = 1f
                        view.layoutParams = params
                        view.text = "by me"
                    }
                }
            }
        }
    }

}