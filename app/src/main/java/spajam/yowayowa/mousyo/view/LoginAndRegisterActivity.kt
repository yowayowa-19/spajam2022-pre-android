package spajam.yowayowa.mousyo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import spajam.yowayowa.mousyo.databinding.ActivityLoginAndRegisterBinding

class LoginAndRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginAndRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginAndRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}
