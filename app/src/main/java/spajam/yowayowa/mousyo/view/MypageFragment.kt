package spajam.yowayowa.mousyo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import spajam.yowayowa.mousyo.databinding.FragmentMypageBinding
import spajam.yowayowa.mousyo.util.SharedPreferencesService

class MypageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPreferencesService: SharedPreferencesService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        sharedPreferencesService = SharedPreferencesService(requireContext())
        binding.carCheckBoxMypage.isChecked = sharedPreferencesService.useCar()
        binding.airconCheckBoxMypage.isChecked = sharedPreferencesService.useAircon()
        binding.tvCheckBoxMypage.isChecked = sharedPreferencesService.useTv()
        binding.carCheckBoxMypage.setOnClickListener {
            sharedPreferencesService.saveUseCar(binding.carCheckBoxMypage.isChecked)
        }
        binding.airconCheckBoxMypage.setOnClickListener {
            sharedPreferencesService.saveUseCar(binding.airconCheckBoxMypage.isChecked)
        }
        binding.tvCheckBoxMypage.setOnClickListener {
            sharedPreferencesService.saveUseCar(binding.tvCheckBoxMypage.isChecked)
        }
        val userName = sharedPreferencesService.getUserName()!!
        binding.userNameMainPage.text = userName
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
