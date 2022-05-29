package com.virtusa.virginmoney.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.virtusa.virginmoney.domain.model.People

data class PeopleDto(
    val avatar: String,
    val createdAt: String,
    val data: Data?=null,
    val email: String,
    val favouriteColor: String,
    val firstName: String,
    val fromName: String?,
    val id: String,
    @SerializedName("jobtitle")
    val jobTitle: String,
    val lastName: String,
    val to: String
)

fun PeopleDto.toPeople(): People {
    return People(
        avatar=avatar,
        createdAt=createdAt,
        email=email,
        firstName=firstName,
        fromName=fromName,
        id=id,
        lastName=lastName,
        data= data,
        favouriteColor=favouriteColor,
        jobTitle=jobTitle,
    )
}