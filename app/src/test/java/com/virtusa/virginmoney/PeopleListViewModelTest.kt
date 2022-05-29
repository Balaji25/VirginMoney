package com.virtusa.virginmoney

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.virtusa.virginmoney.common.Resource
import com.virtusa.virginmoney.domain.model.People
import com.virtusa.virginmoney.domain.use_case.get_people.GetPeopleUseCase
import com.virtusa.virginmoney.presentation.people_list.PeopleListViewModel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.flow.toList
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class PeopleListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    lateinit var getPeopleUseCase: GetPeopleUseCase

    lateinit var peopleListViewModel: PeopleListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.peopleListViewModel = PeopleListViewModel(this.getPeopleUseCase)
    }

    @Test
    fun fetchUserRepositories_positiveResponse() {
        // Mock API response
        Mockito.`when`(this.getPeopleUseCase()).thenAnswer(){
        }
      val people=  peopleListViewModel.state
        assertEquals(people, mutableListOf<People>() )
    }

}