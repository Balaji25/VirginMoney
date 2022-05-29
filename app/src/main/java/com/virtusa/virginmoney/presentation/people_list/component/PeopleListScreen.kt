package com.virtusa.virginmoney.presentation.people_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.virtusa.virginmoney.R
import com.virtusa.virginmoney.presentation.Screen
import com.virtusa.virginmoney.presentation.people_list.PeopleListViewModel




@Preview(showBackground = true)
@Composable
fun PeopleListScreenPreview(

) {
  //  PeopleListScreen()
}




@Composable
fun PeopleListScreen(
    navController: NavController,
    viewModel: PeopleListViewModel= hiltViewModel()
) {
    val state=viewModel.state.value
    
    Box(modifier = Modifier.fillMaxSize().background(colorResource(id = R.color.purple_100))) {
        LazyColumn(modifier =Modifier.fillMaxSize()){
            items(state.people){people->
                PeopleNewListItem(people =people, onItemClick = {
                    navController.navigate(Screen.PeopleDetailScreen.route+"/${people.id}")
                })
            }
        }


        if (state.error.isNotBlank()){
            Text(
                text =state.error ,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)

                )
        }

        if (state.isLoading){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }
}