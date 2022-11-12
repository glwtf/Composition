package com.example.composition.domain.usecase

import com.example.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {

    operator fun invoke( maxSumValue : Int )
    = repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}