package com.virtusa.virginmoney.presentation.people_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.virtusa.virginmoney.common.Resource
import com.virtusa.virginmoney.domain.use_case.get_people.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PeopleListViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase
):ViewModel(){


    private val _state= mutableStateOf(PeopleListState())
    val state: State<PeopleListState> =_state

    init {
        getPeople()
    }
    private fun getPeople(){
        getPeopleUseCase().onEach { result->
            when(result){
                is Resource.Success->
                {
                    _state.value= PeopleListState(people =result.data?: emptyList())
                }
                is Resource.Error->{
                    _state.value= PeopleListState(error = result.message?:"Unexpected error occurred")
                }

                is Resource.Loading->{
                    _state.value= PeopleListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}