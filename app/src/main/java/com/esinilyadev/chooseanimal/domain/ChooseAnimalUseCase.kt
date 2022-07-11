package com.esinilyadev.chooseanimal.domain

class ChooseAnimalUseCase(private val repository: MainAnimalRepository) {

    fun getAnimal(animal: Int): Boolean{
        return repository.getAnimal(animal)
    }
}