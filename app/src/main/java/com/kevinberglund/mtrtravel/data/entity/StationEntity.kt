package com.kevinberglund.mtrtravel.data.entity

import com.google.gson.annotations.SerializedName

data class StationEntity(

    @SerializedName("RESPONSE")
    val response: StationResponseEntity
)

data class StationResponseEntity(
    @SerializedName("RESULT")
    val results: List<StationResultsEntity>
)

data class StationResultsEntity(
    @SerializedName("TrainAnnouncement")
    val trainAnnouncement: List<TrainAnnouncementEntity>
)

data class TrainAnnouncementEntity(
    @SerializedName("ScheduledDepartureDateTime")
    val scheduledDepartureDateTime: String,
    @SerializedName("ToLocation")
    val toLocation: List<ToLocationEntity>,
    @SerializedName("TrackAtLocation")
    val trackAtLocation: String
)

data class ToLocationEntity(
    @SerializedName("LocationName")
    val locationName: String,
    @SerializedName("Priority")
    val priority: Int,
    @SerializedName("Order")
    val order: Int
)