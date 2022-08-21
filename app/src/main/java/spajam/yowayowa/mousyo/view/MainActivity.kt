package spajam.yowayowa.mousyo.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.databinding.ActivityMainBinding
import spajam.yowayowa.mousyo.util.SharedPreferencesService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferencesService: SharedPreferencesService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_mission, R.id.navigation_ranking, R.id.navigation_mypage
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // ログインしていない場合
        sharedPreferencesService = SharedPreferencesService(this)
        if (sharedPreferencesService.getUserId() == -1) {
            startActivity(Intent(this, OnboardingActivity::class.java))
            this.finish()
        }
    }
}
