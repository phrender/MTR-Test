package com.kevinberglund.mtrtravel.mappers

import com.kevinberglund.mtrtravel.common.IMapper
import com.kevinberglund.mtrtravel.data.entity.StationEntity
import com.kevinberglund.mtrtravel.data.entity.ToLocationEntity
import com.kevinberglund.mtrtravel.data.entity.TrainAnnouncementEntity
import com.kevinberglund.mtrtravel.models.StationModel
import com.kevinberglund.mtrtravel.models.ToLocationModel
import com.kevinberglund.mtrtravel.models.TrainAnnouncementModel

class StationMapper : IMapper<StationModel, StationEntity> {

    override fun map(model: StationEntity): StationModel =
        model.toStationModel()
}

fun StationEntity.toStationModel() = StationModel(
    response.results.first().trainAnnouncement.map { it.toTrainAnnouncementModel() }
)

fun TrainAnnouncementEntity.toTrainAnnouncementModel() = TrainAnnouncementModel(
    scheduledDepartureDateTime,
    toLocation.map { it.toToLocationModel() },
    trackAtLocation
)

fun ToLocationEntity.toToLocationModel() = ToLocationModel(
    locationName,
    priority,
    order
)