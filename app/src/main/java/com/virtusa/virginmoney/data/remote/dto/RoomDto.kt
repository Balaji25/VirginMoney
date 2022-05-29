package com.virtusa.virginmoney.data.remote.dto

data class RoomDto(
    val createdAt: String,
    val id: String,
    val isOccupied: Boolean,
    val maxOccupancy: Int
)