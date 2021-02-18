package com.kevinberglund.mtrtravel.repository

import com.kevinberglund.mtrtravel.common.IMapper
import com.kevinberglund.mtrtravel.data.MtrApi
import com.kevinberglund.mtrtravel.data.Result
import com.kevinberglund.mtrtravel.data.entity.StationEntity
import com.kevinberglund.mtrtravel.extension.apiCall
import com.kevinberglund.mtrtravel.mappers.StationMapper
import com.kevinberglund.mtrtravel.models.StationModel

class StationRepository(
    private val api: MtrApi,
    private val mapper: IMapper<StationModel, StationEntity> = StationMapper()
) : BaseRepository<StationModel>() {

    override suspend fun fetch(): Result<StationModel> =
        apiCall(mapper) { api.getSocTimeTable() }
}