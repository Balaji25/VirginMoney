package com.virtusa.virginmoney.presentation.people_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.virtusa.virginmoney.common.Constants
import com.virtusa.virginmoney.domain.model.People
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){


    private val _state= mutableStateOf(PeopleDetailState())
    val state: State<PeopleDetailState> =_state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PEOPLE_DATA)?.let { coinId ->
           // getCoin(coinId)
            _state.value=  PeopleDetailState(people =People("","","","","","","",
            null,"",""))
        }

        /*savedStateHandle.get<People>(Constants.PARAM_PEOPLE_DATA)?.let { peopleDetail ->
            _state.value=  PeopleDetailState(people =peopleDetail)
        }*/
    }

   /* init {
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
    }*/
}