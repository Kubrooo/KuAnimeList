package com.example.submissionakhirdicoding

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("TITLE")
        val description = intent.getStringExtra("DESCRIPTION")
        val episode = intent.getIntExtra("EPISODE", 0)
        val detailPhoto = intent.getIntExtra("DETAIL_PHOTO", 0)

        findViewById<TextView>(R.id.tvJudulAnime).text = title
        findViewById<TextView>(R.id.tvEpisodeAnime).text = "$episode Episode"
        findViewById<TextView>(R.id.tvDekskripsiAnime).text = description
        findViewById<ImageView>(R.id.imgViewAnime).setImageResource(detailPhoto)

        val shareButton: Button = findViewById(R.id.action_share)
        shareButton.setOnClickListener {
            shareAnimeDetails(title, description, episode)
        }
    }

    private fun shareAnimeDetails(title: String?, description: String?, episode: Int) {
        val shareText = "Anime: $title\n\nEpisode: $episode\n\nDekskripsi:\n$description"

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }

        val shareIntent = Intent.createChooser(intent, "Share via")
        startActivity(shareIntent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
