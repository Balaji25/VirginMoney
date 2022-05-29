package com.virtusa.virginmoney.presentation.people_list

import com.virtusa.virginmoney.domain.model.People


data class PeopleListState(
    val isLoading:Boolean=false,
    val people:List<People> = emptyList(),
    val error: String=""
)
