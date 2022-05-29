package com.virtusa.virginmoney.domain.repository

import com.virtusa.virginmoney.data.remote.dto.PeopleDto

interface PeopleRepository {
    suspend fun getPeople():List<PeopleDto>
}