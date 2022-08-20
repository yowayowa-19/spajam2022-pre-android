package spajam.yowayowa.mousyo.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root = binding.root
        binding.loginButton.setOnClickListener {
            val username = binding.editTextTextUserName.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            if (login(username, password)) {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                activity?.finish()
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

    // TODO:Implementation
    private fun login(username: String, password: String): Boolean {
        return true
    }
}
