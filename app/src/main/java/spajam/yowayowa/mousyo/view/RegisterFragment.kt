package spajam.yowayowa.mousyo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val root = binding.root
        binding.registerButton.setOnClickListener {
            val navHostFragment = requireActivity()
                .supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment_login_and_register) as NavHostFragment
            val navController = navHostFragment.navController
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            navController.navigate(action)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
