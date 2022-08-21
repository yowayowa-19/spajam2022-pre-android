package spajam.yowayowa.mousyo.view.mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import spajam.yowayowa.mousyo.databinding.FragmentRankingTemplateBinding

class DailyMissionFragment : Fragment() {

    private lateinit var dailyMissionViewModel: DailyMissionViewModel
    private var _binding: FragmentRankingTemplateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dailyMissionViewModel = ViewModelProvider(this)[DailyMissionViewModel::class.java]
        _binding = FragmentRankingTemplateBinding.inflate(inflater, container, false)
        dailyMissionViewModel.missions.observe(viewLifecycleOwner, Observer {
            binding.recyclerView.setHasFixedSize(true)
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = DailyMissionAdapter(it)
            binding.recyclerView.addItemDecoration(
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            )
        })
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
