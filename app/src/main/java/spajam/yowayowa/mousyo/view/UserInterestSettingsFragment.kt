package spajam.yowayowa.mousyo.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import spajam.yowayowa.mousyo.databinding.FragmentUserInterestSettingBinding
import spajam.yowayowa.mousyo.util.SharedPreferencesService

class UserInterestSettingsFragment : Fragment() {
    private var _binding: FragmentUserInterestSettingBinding? = null
    private val binding get() = _binding!!
    lateinit var userInterestSettingsViewModel: UserInterestSettingsViewModel
    private lateinit var sharedPreferencesService: SharedPreferencesService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInterestSettingBinding.inflate(inflater, container, false)
        val root = binding.root
        userInterestSettingsViewModel = ViewModelProvider(this)[UserInterestSettingsViewModel::class.java]
        sharedPreferencesService = SharedPreferencesService(requireContext())

        binding.carCheckBox.setOnClickListener {
            userInterestSettingsViewModel.setHaveCar(
                binding.carCheckBox.isChecked
            )
        }
        binding.airconCheckBox.setOnClickListener {
            userInterestSettingsViewModel.setHaveAircon(
                binding.airconCheckBox.isChecked
            )
        }
        binding.tvCheckBox.setOnClickListener {
            userInterestSettingsViewModel.setHaveTv(
                binding.tvCheckBox.isChecked
            )
        }
        binding.endButton.setOnClickListener {
            sharedPreferencesService.saveUseCar(userInterestSettingsViewModel.haveCar.value ?: false)
            sharedPreferencesService.saveUseAircon(userInterestSettingsViewModel.haveAircon.value ?: false)
            sharedPreferencesService.saveUseTv(userInterestSettingsViewModel.haveTv.value ?: false)

            startActivity(Intent(context, MainActivity::class.java))
            activity?.finish()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
