package com.virtusa.virginmoney.data.remote

import com.virtusa.virginmoney.data.remote.dto.PeopleDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleContactApi {

    @GET("/api/v1/people")
    suspend fun getPeople(): List<PeopleDto>

    @GET("/api/v1/people/{id}")
    suspend fun getPeopleDetails(@Path("id") peopleId:String): PeopleDto

}