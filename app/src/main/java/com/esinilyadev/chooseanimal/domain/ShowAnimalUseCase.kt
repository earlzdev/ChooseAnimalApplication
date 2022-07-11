package com.esinilyadev.chooseanimal.domain

class ShowAnimalUseCase(private val repository: MainAnimalRepository) {

    fun showAnimal(): Int {
        return repository.showAnimal()
    }
}