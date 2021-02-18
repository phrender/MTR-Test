package com.kevinberglund.mtrtravel.usecase

import com.kevinberglund.mtrtravel.repository.RepositoryFactory

@Suppress("EXPERIMENTAL_API_USAGE")
class UseCaseFactory(
    private val repositoryFactory: RepositoryFactory
) {

    fun getStationUseCase() = StationFlowUseCase(repositoryFactory.getStationRepository())
}