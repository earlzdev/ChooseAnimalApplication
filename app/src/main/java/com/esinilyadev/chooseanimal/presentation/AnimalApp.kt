package com.esinilyadev.chooseanimal.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.esinilyadev.chooseanimal.sl.CoreModule
import com.esinilyadev.chooseanimal.sl.DependencyContainer
import com.esinilyadev.chooseanimal.sl.ViewModelsFactory

class AnimalApp: Application() {

    private lateinit var coreModule: CoreModule
    private val factory by lazy {
        ViewModelsFactory(DependencyContainer.Base(coreModule, this))
    }

    override fun onCreate() {
        super.onCreate()
        coreModule = CoreModule()
        coreModule.init(this)
    }

    fun <T: ViewModel> viewModel(modelClass: Class<T>, owner: ViewModelStoreOwner): T {
        return ViewModelProvider(owner, factory)[modelClass]
    }
}