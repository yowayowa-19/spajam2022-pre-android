package spajam.yowayowa.mousyo.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.runBlocking
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.databinding.FragmentRegisterBinding
import spajam.yowayowa.mousyo.repository.AccountRepository

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    lateinit var registerViewModel: RegisterViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val accountRepository = AccountRepository()
        val factory = RegisterViewModel.Factory(accountRepository)
        registerViewModel = ViewModelProvider(this, factory)[RegisterViewModel::class.java]
        val root = binding.root

        binding.editTextTextPersonName.doOnTextChanged { text, start, count, after ->
            registerViewModel.setUsername(text.toString())
        }
        binding.editTextRegisterTextPassword.doOnTextChanged { text, start, count, after ->
            registerViewModel.setPassword(text.toString())
        }
        binding.registerButton.setOnClickListener {
            runBlocking {
                val result = registerViewModel.register()
                if (result) {
                    Toast.makeText(context, "ユーザー登録が完了しました\n ログインしてください", Toast.LENGTH_SHORT).show()
                    navigate()
                } else Toast.makeText(context, "ユーザー登録に失敗しました", Toast.LENGTH_SHORT).show()
            }
        }
        binding.clickableTextView.setOnClickListener {
            navigate()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigate() {
        val navHostFragment = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_login_and_register) as NavHostFragment
        val navController = navHostFragment.navController
        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        navController.navigate(action)
    }
}
