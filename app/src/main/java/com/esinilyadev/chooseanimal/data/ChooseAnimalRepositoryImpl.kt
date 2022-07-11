package com.esinilyadev.chooseanimal.data

import android.util.Log
import com.esinilyadev.chooseanimal.R
import com.esinilyadev.chooseanimal.domain.MainAnimalRepository

class ChooseAnimalRepositoryImpl: MainAnimalRepository {

    private val animList: Map<Int, List<Int>> = mapOf(
        DOG_KEY to listOf(
            R.mipmap.ic_dog1,
            R.mipmap.ic_dog2
        ),
        CAT_KEY to listOf(
            R.mipmap.ic_cat1,
            R.mipmap.ic_cat2
        ),
        BIRD_KEY to listOf(
            R.mipmap.ic_bird
        )
    )

    private var animalKey = DEFAULT_KEY

    override fun showAnimal(): Int {

        val pictureToShow = animList.map { it.value }.random()
        animalKey = animList.filter { it.value.hashCode() == pictureToShow.hashCode() }.keys.first()
        return pictureToShow.random()
    }

    override fun getAnimal(animal: Int): Boolean {
        Log.d("tag", "getAnimal: $animal")
        return if (animal == animalKey) true
        else if (animal != animalKey) false
        else throw IllegalStateException("No such animal $animal")
    }

    companion object {
        const val DEFAULT_KEY = -1
        const val DOG_KEY = 0
        const val CAT_KEY = 1
        const val BIRD_KEY = 2
    }
}

