package com.kevinberglund.mtrtravel.models

data class StationModel(
    val trainAnnouncement: List<TrainAnnouncementModel>
)

data class TrainAnnouncementModel(
    val scheduledDepartureDateTime: String,
    val toLocation: List<ToLocationModel>,
    val trackAtLocation: String
)

data class ToLocationModel(
    val locationName: String,
    val priority: Int,
    val order: Int
)