package com.example.submissionakhirdicoding

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        // Sembunyikan ActionBar
        supportActionBar?.hide()

        val splashImage: View = findViewById(R.id.splash_image)
        val progressBar: View = findViewById(R.id.progressBar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Animasi gambar di splash screen
        animateSplashLogo(splashImage)

        // Timer untuk splash screen sebelum pindah ke MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            moveToMainActivity()
        }, 3000L)
    }


    private fun animateSplashLogo(view: View) {
        // Animasi scale (zoom-in)
        ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1f).apply {
            duration = 2000
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }

        ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1f).apply {
            duration = 2000
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }

        // Fade-in animation
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 1500
        view.startAnimation(fadeIn)
    }

    private fun moveToMainActivity() {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}
