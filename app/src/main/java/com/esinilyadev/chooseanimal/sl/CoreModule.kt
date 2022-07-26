package com.esinilyadev.chooseanimal.sl

import android.content.Context
import com.esinilyadev.chooseanimal.data.ChooseAnimalRepositoryImpl
import com.esinilyadev.chooseanimal.domain.ChooseAnimalUseCase
import com.esinilyadev.chooseanimal.domain.ShowAnimalUseCase
import com.esinilyadev.chooseanimal.presentation.ResourceProvider

class CoreModule {

    lateinit var provider: ResourceProvider
    lateinit var chooseAnimalUseCase: ChooseAnimalUseCase
    lateinit var showAnimalUseCase: ShowAnimalUseCase

    fun init(context: Context) {
        val repository = ChooseAnimalRepositoryImpl()
        provider = ResourceProvider.Base(context)
        chooseAnimalUseCase = ChooseAnimalUseCase(repository)
        showAnimalUseCase = ShowAnimalUseCase(repository)
    }

}