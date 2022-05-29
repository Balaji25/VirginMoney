package com.virtusa.virginmoney.presentation.room_list

import com.virtusa.virginmoney.data.remote.dto.RoomDto


data class RoomsListState(
    val isLoading:Boolean=false,
    val rooms:List<RoomDto> = emptyList(),
    val error: String=""
)
