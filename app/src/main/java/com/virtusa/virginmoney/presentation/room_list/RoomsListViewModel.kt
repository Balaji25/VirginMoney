package com.virtusa.virginmoney.presentation.room_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.virtusa.virginmoney.common.Resource
import com.virtusa.virginmoney.domain.use_case.get_rooms.GetRoomsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RoomsListViewModel @Inject constructor(
    private val getRoomsUseCase: GetRoomsUseCase
):ViewModel(){


    private val _state= mutableStateOf(RoomsListState())
    val state: State<RoomsListState> =_state

    init {
        getRooms()
    }
    private fun getRooms(){
        getRoomsUseCase().onEach { result->
            when(result){
                is Resource.Success->
                {
                    _state.value= RoomsListState(rooms =result.data?: emptyList())
                }
                is Resource.Error->{
                    _state.value= RoomsListState(error = result.message?:"Unexpected error occurred.")
                }
                is Resource.Loading->{
                    _state.value= RoomsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}