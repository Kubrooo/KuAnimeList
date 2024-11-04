package com.example.submissionakhirdicoding

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test

class StringResourceTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun testAppName() {
        val expectedAppName = "Ku Anime List"
        val actualAppName = context.getString(R.string.app_name)
        assertEquals(expectedAppName, actualAppName)

    }

    @Test
    fun testAnimeTitle() {
        val expectedAnimeTitle = "Judul Anime"
        val actualAnimeTitle = context.getString(R.string.anime_title)
        assertEquals(expectedAnimeTitle, actualAnimeTitle)

    }

    @Test
    fun testDescriptionLabel() {
        val expectedDescriptionLabel = "Deskripsi"
        val actualDescriptionLabel = context.getString(R.string.description)
        assertEquals(expectedDescriptionLabel, actualDescriptionLabel)

    }

    @Test
    fun testEpisodeLabel() {
        val expectedEpisodeLabel = "Episode"
        val actualEpisodeLabel = context.getString(R.string.episode)
        assertEquals(expectedEpisodeLabel, actualEpisodeLabel)

    }

    @Test
    fun testAboutMeContent() {
        val expectedAboutMeContent = "Halo! Nama saya Galih Tri Ardiansyah. Saya sangat menyukai dunia teknologi, terutama dalam hal coding. Di luar kesibukan, saya sering menghabiskan waktu dengan bermain game, berenang untuk menyegarkan pikiran, serta menikmati berbagai cerita dari manga dan anime favorit. Semua hal itu adalah bagian dari keseharian yang membuat saya terus semangat untuk belajar hal-hal baru."
        val actualAboutMeContent = context.getString(R.string.about_me)
        assertEquals(expectedAboutMeContent, actualAboutMeContent)

    }

    @Test
    fun testEmailLabel() {
        val expectedEmailLabel = "Email :"
        val actualEmailLabel = context.getString(R.string.email_label)
        assertEquals(expectedEmailLabel, actualEmailLabel)
    }

    @Test
    fun testHobbiesLabel() {
        val expectedHobbiesLabel = "Hobbies :"
        val actualHobbiesLabel = context.getString(R.string.hobbies_label)
        assertEquals(expectedHobbiesLabel, actualHobbiesLabel)

    }

    @Test
    fun testHobbiesContent() {
        val expectedHobbies = "- Coding\n- Bermain Game\n- Berenang\n- Membaca Manga\n- Nonton Anime"
        val actualHobbies = context.getString(R.string.hobbies)
        assertEquals(expectedHobbies, actualHobbies)

    }
}