package com.virtusa.virginmoney.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.virtusa.virginmoney.R
import com.virtusa.virginmoney.presentation.people_list.component.PeopleListScreen
import com.virtusa.virginmoney.presentation.room_list.component.RoomListScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    class People(navController: NavController) : TabItem(R.drawable.ic_people, "People", { PeopleListScreen(navController) })
    object Rooms : TabItem(R.drawable.ic_rooms, "Rooms", { RoomListScreen() })
}
