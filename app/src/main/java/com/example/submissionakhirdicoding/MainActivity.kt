package com.example.submissionakhirdicoding

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvAnime = findViewById(R.id.rv_anime)
        rvAnime.setHasFixedSize(true)

        list.addAll(getListAnime())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListAnime(): ArrayList<Anime>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataEpisode = resources.getIntArray(R.array.data_episode)
        val detailPhoto = resources.obtainTypedArray(R.array.detail_photo)

        val listAnime = ArrayList<Anime>()

        for(i in dataName.indices){
            val anime = Anime(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),dataEpisode[i], detailPhoto.getResourceId(i, -1))
            listAnime.add(anime)
        }
        return listAnime
    }

    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)

        // Mengirim data saat item diklik
        val listAnimeAdapter = ListAnimeAdapter(list) { anime ->
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra("TITLE", anime.name)
            intent.putExtra("DESCRIPTION", anime.description)
            intent.putExtra("EPISODE", anime.episode)
            intent.putExtra("DETAIL_PHOTO",anime.detPhoto)
            startActivity(intent)
        }

        rvAnime.adapter = listAnimeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val aboutIntent = Intent(this, AboutActivity::class.java)
                startActivity(aboutIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}