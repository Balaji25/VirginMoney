package com.virtusa.virginmoney

import android.os.Build
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.virtusa.virginmoney.presentation.MainActivity
import org.junit.Rule
import org.junit.Test



@ExperimentalTestApi
class TabBarTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun setContentTest() {
        composeTestRule.setContent {
            Text("Virgin Money App")
        }
    }


    @Test
    fun setAppBarColor() {
        composeTestRule.setContent {
            TopAppBar(backgroundColor = colorResource(id = R.color.purple_300),
                contentColor = Color.White) {
                
            }
        }
    }



    @Test
    fun testRoomsTabClick() {
        val tab = composeTestRule.onNodeWithText("Rooms")
        tab.assertIsDisplayed()
        tab.performClick()
    }

    @Test
    fun testPeopleTabClick() {
        val tab = composeTestRule.onNodeWithText("People")
        tab.assertIsDisplayed()
        tab.performClick()
    }

}