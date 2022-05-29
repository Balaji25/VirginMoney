package com.virtusa.virginmoney.data.repository

import com.virtusa.virginmoney.data.remote.PeopleContactApi
import com.virtusa.virginmoney.data.remote.dto.PeopleDto
import com.virtusa.virginmoney.domain.repository.PeopleRepository
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val api: PeopleContactApi
): PeopleRepository{
    override suspend fun getPeople(): List<PeopleDto> {
        return api.getPeople()
    }
}