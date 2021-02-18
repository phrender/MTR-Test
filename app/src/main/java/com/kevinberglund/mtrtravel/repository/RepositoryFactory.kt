package com.kevinberglund.mtrtravel.repository

import com.kevinberglund.mtrtravel.data.MtrApi

class RepositoryFactory(
    private val api: MtrApi
) {
    fun getStationRepository() = StationRepository(api)
}