package com.virtusa.virginmoney.domain.use_case.get_people

import com.virtusa.virginmoney.common.Resource
import com.virtusa.virginmoney.data.remote.dto.toPeople
import com.virtusa.virginmoney.domain.model.People
import com.virtusa.virginmoney.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(
    private val repository: PeopleRepository
) {
    operator fun invoke(): Flow<Resource<List<People>>> = flow {
        try {
            emit(Resource.Loading<List<People>>())
            val people = repository.getPeople().map { it.toPeople() }
            emit(Resource.Success<List<People>>(people))
        } catch(e: HttpException) {
            emit(Resource.Error<List<People>>(e.localizedMessage ?: "An unexpected error occurred."))
        } catch(e: IOException) {
            emit(Resource.Error<List<People>>("Couldn't reach to server. Check your internet connection."))
        }
    }
}