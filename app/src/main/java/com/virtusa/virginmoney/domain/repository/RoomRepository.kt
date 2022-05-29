package com.virtusa.virginmoney.domain.repository

import com.virtusa.virginmoney.data.remote.dto.RoomDto

interface RoomRepository {
    suspend fun getRooms():List<RoomDto>
}