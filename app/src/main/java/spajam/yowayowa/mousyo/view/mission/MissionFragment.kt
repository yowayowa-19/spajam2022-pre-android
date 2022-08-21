package spajam.yowayowa.mousyo.view.mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import spajam.yowayowa.mousyo.databinding.FragmentMissionBinding

val tabLayoutLabels = arrayOf(
    "デイリー",
    "ウィークリー",
)
class MissionFragment : Fragment() {
    private var _binding: FragmentMissionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMissionBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = TabPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabLayoutLabels[position]
        }.attach()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
