package com.virtusa.virginmoney.presentation.people_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.virtusa.virginmoney.domain.model.People

import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider

import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.virtusa.virginmoney.R


@Composable
fun PeopleDetailScreen(viewModel: PeopleDetailViewModel = hiltViewModel(),
                       ){
    val state = viewModel.state.value
    val scrollState = rememberScrollState()
    state.people?.let {
        ProfileHeader(
        scrollState,
            it,
        1000.dp
    )
    }
    state.people?.let { ProfileContent(it, /*this@BoxWithConstraints.maxHeight*/1000.dp) }
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    people: People,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(painter = rememberImagePainter(people.avatar),
        contentDescription = null,
        contentScale = ContentScale.Crop,

        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp)
    )
}

@Composable
private fun ProfileContent(people: People, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Name(people = people)



        ProfileProperty(stringResource(R.string.employee_name), "${people.firstName} ${people.lastName}")

        ProfileProperty(stringResource(R.string.employee_email), people.email)

        ProfileProperty(stringResource(R.string.employee_job_title), people.jobTitle)

        ProfileProperty(stringResource(R.string.employee_fav_color), people.favouriteColor)

        ProfileProperty(stringResource(R.string.meeting_id), people.data?.meetingid?:"")

        ProfileProperty(stringResource(R.string.meeting_name), people.data?.title?:"")

        ProfileProperty(stringResource(R.string.meeting_desc), people.data?.body?:"")


        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Name(
    people: People
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        PeopleName(
            people = people
        )
    }
}

@Composable
private fun PeopleName(people: People) {
    Text(
        text = people.firstName,
        modifier = Modifier.padding(32.dp),
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                modifier = Modifier.paddingFromBaseline(24.dp),
                style = MaterialTheme.typography.caption,
            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }
        Text(
            text = value,
            modifier = Modifier.paddingFromBaseline(24.dp),
            style = style
        )
    }
}


/*@Preview
@Composable
fun ProfilePreview() {
    val puppy = DataProvider.puppy
    ProfileScreen(puppy = puppy)
}*/

