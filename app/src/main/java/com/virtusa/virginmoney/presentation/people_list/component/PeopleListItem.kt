package com.virtusa.virginmoney.presentation.people_list.component

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.virtusa.virginmoney.domain.model.People


@Composable
    fun PeopleListItem(people: People,
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
fun PeopleNewListItem(people: People,onItemClick:(People)->Unit) {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row (
            modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(people) }
            .padding(20.dp)) {
            PeopleImage(people = people)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)) {
                Text(text = "${people.firstName} ${people.lastName}", style = typography.h6)
                Text(text = people.jobTitle, style = typography.caption)
                Text(text = people.email, style = typography.caption)
                Text(text = people.createdAt, style = typography.caption)
                people.data?.title?.let { Text(text ="Meeting Desc:$it", style = typography.caption) }
                people.data?.meetingid?.let { Text(text = "Meeting Id:$it", style = typography.caption) }

            }
        }
    }
}


@Composable
private fun PeopleImage(people: People) {
    Image(painter = rememberImagePainter(people.avatar),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}
