package com.kevinberglund.mtrtravel.repository

import com.kevinberglund.mtrtravel.data.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@ExperimentalCoroutinesApi
abstract class BaseRepository<Model : Any> {

    abstract suspend fun fetch(): Result<Model>

    fun get(): Flow<Result<Model>> = flow {
        fetch().let { result ->
            emit(result)
        }
    }
}