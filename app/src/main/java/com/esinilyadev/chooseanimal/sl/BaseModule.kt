package com.esinilyadev.chooseanimal.sl

import androidx.lifecycle.ViewModel

interface BaseModule<T: ViewModel> {
    fun viewModel(): T
}