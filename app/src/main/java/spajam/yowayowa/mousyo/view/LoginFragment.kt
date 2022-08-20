package spajam.yowayowa.mousyo.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.runBlocking
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.databinding.FragmentLoginBinding
import spajam.yowayowa.mousyo.repository.AccountRepository
import spajam.yowayowa.mousyo.util.SharedPreferencesService

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    lateinit var loginViewModel: LoginViewModel
    private val binding get() = _binding!!
    private lateinit var sharedPreferencesService: SharedPreferencesService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val accountRepository = AccountRepository()
        val factory = LoginViewModel.Factory(accountRepository)
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        sharedPreferencesService = SharedPreferencesService(requireContext())
        val root = binding.root

        loginViewModel.loginFailure.observe(
            viewLifecycleOwner,
            Observer {
                if (it)binding.validationTextView.visibility = View.VISIBLE
            }
        )

        binding.editTextTextUserName.doOnTextChanged { text, start, count, after ->
            loginViewModel.setUsername(text.toString())
        }
        binding.editTextTextPassword.doOnTextChanged { text, start, count, after ->
            loginViewModel.setPassword(text.toString())
        }

        binding.loginButton.setOnClickListener {
            runBlocking {
                val result = loginViewModel.login()
                Toast.makeText(context, "result : $result", Toast.LENGTH_SHORT).show()
                if (result != -1) {
                    sharedPreferencesService.saveUserId(result)
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                    activity?.finish()
                } else loginViewModel.loginFailed()
            }
        }
        binding.registerClickableTextView.setOnClickListener {
            val navHostFragment = requireActivity()
                .supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment_login_and_register) as NavHostFragment
            val navController = navHostFragment.navController
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            navController.navigate(action)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
