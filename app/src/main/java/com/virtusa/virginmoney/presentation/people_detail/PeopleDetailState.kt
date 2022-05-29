package com.virtusa.virginmoney.presentation.people_detail

import com.virtusa.virginmoney.domain.model.People


data class PeopleDetailState(
    val isLoading:Boolean=false,
    val people:People? = null,
    val error: String=""
)
