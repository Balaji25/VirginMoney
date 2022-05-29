package com.virtusa.virginmoney.presentation

sealed class Screen(val route:String)
{
    object PeopleListScreen:Screen("people_list_screen")
    object PeopleDetailScreen:Screen("people_detail_screen")
    object RoomListScreen:Screen("room_list_screen")
}
