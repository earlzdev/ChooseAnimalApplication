package com.esinilyadev.chooseanimal.sl

import android.content.Context
import androidx.lifecycle.ViewModel
import com.esinilyadev.chooseanimal.presentation.MainViewModel
import com.esinilyadev.chooseanimal.presentation.ResourceProvider

class MainModule(
    private val coreModule: CoreModule,
    private val context: Context
): BaseModule<ViewModel> {

    override fun viewModel(): ViewModel {
        val provider = ResourceProvider.Base(context)
        return MainViewModel(provider, coreModule)
    }
}