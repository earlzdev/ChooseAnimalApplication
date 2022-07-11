package com.esinilyadev.chooseanimal.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.esinilyadev.chooseanimal.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = (application as AnimalApp).viewModel(MainViewModel::class.java, this)

        viewModel.showAnimalPicture()

        binding.catButton.setOnClickListener {
            viewModel.chooseAnimal(CAT_KEY)
        }

        binding.dogButton.setOnClickListener {
            viewModel.chooseAnimal(DOG_KEY)
        }

        binding.birdButton.setOnClickListener {
            viewModel.chooseAnimal(BIRD_KEY)
        }

        addObservers()
    }

    private fun addObservers(){

        viewModel.observeAnimalPicture(this){
            binding.animalPicturePlace.setImageDrawable(it)
        }

        viewModel.observeRightAnswer(this){
            if (it == true){
                binding.answerRight.isVisible = true
                binding.answerWrong.isVisible = false
                binding.catButton.isEnabled = false
                binding.dogButton.isEnabled = false
                binding.birdButton.isEnabled = false
                lifecycleScope.launch { getAnotherPicture() }
            } else {
                binding.answerWrong.isVisible = true
                binding.answerRight.isVisible = false
            }
        }
    }

    private suspend fun getAnotherPicture(){
        delay(2000)
        viewModel.showAnimalPicture()
        binding.answerRight.isVisible = false
        binding.catButton.isEnabled = true
        binding.dogButton.isEnabled = true
        binding.birdButton.isEnabled = true
    }



    companion object{
        const val DOG_KEY = 0
        const val CAT_KEY = 1
        const val BIRD_KEY = 2
    }
}