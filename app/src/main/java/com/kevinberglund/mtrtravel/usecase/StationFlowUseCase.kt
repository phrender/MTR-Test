package com.kevinberglund.mtrtravel.usecase

import com.kevinberglund.mtrtravel.data.Result
import com.kevinberglund.mtrtravel.data.entity.StationEntity
import com.kevinberglund.mtrtravel.models.StationModel
import com.kevinberglund.mtrtravel.repository.StationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn

@ExperimentalCoroutinesApi
class StationFlowUseCase(
    private val stationRepository: StationRepository
) {

    fun perform(): Flow<Result<StationModel>> =
        stationRepository.get()
            .distinctUntilChanged()
            .flowOn(Dispatchers.IO)
}