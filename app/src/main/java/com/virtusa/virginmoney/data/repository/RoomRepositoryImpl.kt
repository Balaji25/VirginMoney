package com.virtusa.virginmoney.data.repository

import com.virtusa.virginmoney.data.remote.ConferenceRoomApi
import com.virtusa.virginmoney.data.remote.dto.RoomDto
import com.virtusa.virginmoney.domain.repository.RoomRepository
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val api: ConferenceRoomApi
): RoomRepository {
    override suspend fun getRooms(): List<RoomDto> {
        return api.getRooms()
    }
}