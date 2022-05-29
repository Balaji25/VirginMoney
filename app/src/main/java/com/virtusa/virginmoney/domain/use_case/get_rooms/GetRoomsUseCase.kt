package com.virtusa.virginmoney.domain.use_case.get_rooms

import com.virtusa.virginmoney.common.Resource
import com.virtusa.virginmoney.data.remote.dto.RoomDto
import com.virtusa.virginmoney.domain.repository.RoomRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val repository: RoomRepository
) {
    operator fun invoke(): Flow<Resource<List<RoomDto>>> = flow {
        try {
            emit(Resource.Loading<List<RoomDto>>())
            val rooms = repository.getRooms()
            emit(Resource.Success<List<RoomDto>>(rooms))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<RoomDto>>(
                    e.localizedMessage ?: "An unexpected error occurred."
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<RoomDto>>("Couldn't reach to server. Check your internet connection."))
        }

    }
}