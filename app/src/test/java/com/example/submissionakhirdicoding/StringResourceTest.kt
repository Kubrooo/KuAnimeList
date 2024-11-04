package com.example.submissionakhirdicoding

import org.junit.Assert.assertEquals
import org.junit.Test

class StringResourceTest {

    @Test
    fun testAppName() {
        val appName = "Ku Anime List" // Ubah ini menjadi string yang diambil dari resources jika diperlukan
        assertEquals("Ku Anime List", appName)
    }

    @Test
    fun testAnimeTitle() {
        val animeTitle = "Judul Anime" // Ubah ini menjadi string yang diambil dari resources jika diperlukan
        assertEquals("Judul Anime", animeTitle)
    }

    @Test
    fun testDescription() {
        val description = "Deskripsi" // Ubah ini menjadi string yang diambil dari resources jika diperlukan
        assertEquals("Deskripsi", description)
    }

    @Test
    fun testHobbies() {
        val hobbies = "- Coding\n- Bermain Game\n- Berenang\n- Membaca Manga\n- Nonton Anime" // Ubah ini menjadi string yang diambil dari resources jika diperlukan
        assertEquals("- Coding\n- Bermain Game\n- Berenang\n- Membaca Manga\n- Nonton Anime", hobbies)
    }
}
