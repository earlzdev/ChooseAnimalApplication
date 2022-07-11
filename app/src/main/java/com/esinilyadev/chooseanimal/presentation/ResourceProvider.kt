package com.esinilyadev.chooseanimal.presentation

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes

interface ResourceProvider {

    fun showPicture(@DrawableRes drawableRes: Int): Drawable?
//    fun getAnimal(@StringRes stringRes: Int): String

    class Base(private val context: Context): ResourceProvider {
        override fun showPicture(drawableRes: Int): Drawable? {
            return context.getDrawable(drawableRes)
        }
//
//        override fun getAnimal(stringRes: Int): String {
//            return context.getString(stringRes)
//        }
    }
}