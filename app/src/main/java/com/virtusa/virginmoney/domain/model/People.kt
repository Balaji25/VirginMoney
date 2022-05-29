package com.virtusa.virginmoney.domain.model

import com.google.gson.annotations.SerializedName
import com.virtusa.virginmoney.data.remote.dto.Data

data class People(
    val avatar: String,
    val createdAt: String,
    val email: String,
    val firstName: String,
    val fromName: String?,
    val id: String,
    val lastName: String,
    val data: Data?=null,
    val favouriteColor: String,
    @SerializedName("jobtitle")
    val jobTitle: String,
)
