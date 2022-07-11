package com.esinilyadev.chooseanimal.di

import android.content.Context

interface DependencyContainer {

    fun module(feature: Feature): BaseModule<*>

    class Base(private val coreModule: CoreModule, private val context: Context): DependencyContainer{
        override fun module(feature: Feature): BaseModule<*> {
            return when (feature){
                Feature.CHOOSE_ANIMAL -> MainModule(coreModule, context)
            }
        }
    }
}