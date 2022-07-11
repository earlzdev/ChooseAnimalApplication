package com.esinilyadev.chooseanimal.domain

interface MainAnimalRepository {

    fun getAnimal(animal: Int): Boolean

    fun showAnimal(): Int
}