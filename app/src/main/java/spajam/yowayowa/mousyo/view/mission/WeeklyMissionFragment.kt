package spajam.yowayowa.mousyo.view.mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import spajam.yowayowa.mousyo.databinding.FragmentRankingTemplateBinding

class WeeklyMissionFragment : Fragment() {

    private lateinit var rankingViewModel: WeeklyMissionViewModel
    private var _binding: FragmentRankingTemplateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rankingViewModel = ViewModelProvider(this)[WeeklyMissionViewModel::class.java]
        _binding = FragmentRankingTemplateBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
