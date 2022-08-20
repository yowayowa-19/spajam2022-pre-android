package spajam.yowayowa.mousyo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.databinding.FragmentLoginAcceptedBinding

class LoginAcceptedFragment : Fragment() {
    private var _binding: FragmentLoginAcceptedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginAcceptedBinding.inflate(inflater, container, false)
        val root = binding.root
        binding.button.setOnClickListener {
            navigate()
        }
        return root
    }

    private fun navigate() {
        val navHostFragment = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_login_and_register) as NavHostFragment
        val navController = navHostFragment.navController
        val action = LoginAcceptedFragmentDirections.actionLoginAcceptedFragmentToUserInterestSettingsFragment()
        navController.navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
