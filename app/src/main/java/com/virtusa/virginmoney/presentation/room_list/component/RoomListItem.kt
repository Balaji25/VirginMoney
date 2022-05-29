package com.virtusa.virginmoney.presentation.room_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.virtusa.virginmoney.data.remote.dto.RoomDto
import com.virtusa.virginmoney.domain.model.People


@Composable
    fun RoomListItem(people: People,
                     onItemClick:(People)->Unit)
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick }
            .padding(20.dp)) 
        {
            Text(text =" ${people.firstName}. ${people.lastName} (${people.email})",
            style = MaterialTheme.typography.body1,
              overflow = TextOverflow.Ellipsis
            )
            
            Text(text = people.createdAt,
            color =  Color.Green ,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                modifier = Modifier.align(CenterVertically)
            )
           
        }

    }


@Composable
fun RoomNewListItem(roomDto: RoomDto) {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row (
            modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)) {
                Text(text = "Conf. No:${roomDto.id} ", style = typography.h6)
                Text(text = "Max Limit:${roomDto.maxOccupancy} ", style = typography.h6)
                Text(text = if(roomDto.isOccupied) "Occupied" else "Not Occupied",
                    color= if(roomDto.isOccupied) Color.Red else Color.Green,
                    style = typography.caption)
                Text(text = roomDto.createdAt, style = typography.caption)
            }
        }
    }
}

