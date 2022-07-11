package com.esinilyadev.chooseanimal.di

import androidx.lifecycle.ViewModel

interface BaseModule<T: ViewModel> {
    fun viewModel(): T
}