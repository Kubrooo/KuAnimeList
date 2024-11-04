package com.example.submissionakhirdicoding

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AnimeIntegrationTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun testAnimeTitleResource() {
        val expectedTitle = context.getString(R.string.anime_title)
        onView(withId(R.id.tvJudulAnime)).check(matches(withText(expectedTitle)))
    }

    @Test
    fun testDataBindingAnimeList() {
        val expectedAnimeName = context.resources.getStringArray(R.array.data_name)[0]
        onView(withText(expectedAnimeName)).check(matches(isDisplayed()))

    }

    @Test
    fun testShareButton() {
        onView(withId(R.id.action_share)).check(matches(isClickable()))

    }

    @Test
    fun testEpisodesDisplayCorrectly() {
        val expectedEpisodes = context.resources.getIntArray(R.array.data_episode)[0]
        onView(withText("$expectedEpisodes Episodes")).check(matches(isDisplayed()))
    }

}