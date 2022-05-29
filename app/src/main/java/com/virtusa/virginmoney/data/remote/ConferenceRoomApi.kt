package com.virtusa.virginmoney.data.remote

import com.virtusa.virginmoney.data.remote.dto.RoomDto
import retrofit2.http.GET

interface ConferenceRoomApi {

    @GET("/api/v1/rooms")
    suspend fun getRooms(): List<RoomDto>

}