package spajam.yowayowa.mousyo.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import spajam.yowayowa.mousyo.databinding.ActivityMainBinding
import spajam.yowayowa.mousyo.util.SharedPreferencesService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // debug
        binding.textView.text = "user_id : ${SharedPreferencesService(this).getUserId()}"
        binding.textView.setOnClickListener {
            startActivity(Intent(this, OnboardingActivity::class.java))
            this.finish()
        }
    }
}
