package spajam.yowayowa.mousyo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.databinding.ActivityLoginAndRegisterBinding

class LoginAndRegisterActivity: AppCompatActivity(){
    private lateinit var binding : ActivityLoginAndRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginAndRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_login_and_register) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
