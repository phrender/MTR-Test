package com.kevinberglund.mtrtravel.usecase

interface ArgUseCase<ReturnType : Any, Argument : Any> {
    fun perform(argument: Argument): ReturnType
}