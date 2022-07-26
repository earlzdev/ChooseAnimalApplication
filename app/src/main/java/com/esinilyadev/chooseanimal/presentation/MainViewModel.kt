package com.esinilyadev.chooseanimal.presentation

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.lifecycle.*
import com.esinilyadev.chooseanimal.sl.CoreModule

class MainViewModel(
    private val provider: ResourceProvider,
    private val coreModule: CoreModule
): ViewModel() {

    private val showAnimalLD = MutableLiveData<Drawable>()
    private val getAnimalLD = MutableLiveData<Boolean>()

    fun observeAnimalPicture(owner: LifecycleOwner, observer: Observer<Drawable>){
        showAnimalLD.observe(owner, observer)
    }

    fun showAnimalPicture(){
        val result = coreModule.showAnimalUseCase.showAnimal()
        showAnimalLD.value = provider.showPicture(result)
    }

    fun observeRightAnswer(owner: LifecycleOwner, observer: Observer<Boolean>){
        getAnimalLD.observe(owner, observer)
    }

    fun chooseAnimal(animal: Int){
        val result = coreModule.chooseAnimalUseCase.getAnimal(animal)
        Log.d("tag", "chooseAnimal: $result")
        getAnimalLD.value = result
    }
}