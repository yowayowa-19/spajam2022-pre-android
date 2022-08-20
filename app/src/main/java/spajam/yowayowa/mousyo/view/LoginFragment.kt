package spajam.yowayowa.mousyo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    lateinit var loginViewModel: LoginViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val root = binding.root

        binding.editTextTextUserName.doOnTextChanged { text, start, count, after ->
            loginViewModel.setUsername(text.toString())
        }
        binding.editTextTextPassword.doOnTextChanged { text, start, count, after ->
            loginViewModel.setPassword(text.toString())
        }

        binding.loginButton.setOnClickListener {
            if (login(loginViewModel.usernameText.value, loginViewModel.passwordText.value)) {
                navigateToLoginAcceptedFragment()
            }
        }
        binding.registerClickableTextView.setOnClickListener {
            navigateToRegisterFragment()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToRegisterFragment() {
        val navHostFragment = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_login_and_register) as NavHostFragment
        val navController = navHostFragment.navController
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        navController.navigate(action)
    }

    private fun navigateToLoginAcceptedFragment() {
        val navHostFragment = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_login_and_register) as NavHostFragment
        val navController = navHostFragment.navController
        val action = LoginFragmentDirections.actionLoginFragmentToLoginAcceptedFragment()
        navController.navigate(action)
    }

    // TODO:Implementation
    private fun login(username: String?, password: String?): Boolean {
        println("username : $username, password : $password")
        return true
    }
}
