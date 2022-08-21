package spajam.yowayowa.mousyo.view.mission

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import spajam.yowayowa.mousyo.databinding.FragmentMissionTemplateBinding
import spajam.yowayowa.mousyo.model.Mission

class WeeklyMissionFragment : Fragment() {

    private lateinit var weekMissionViewModel: WeeklyMissionViewModel
    private var _binding: FragmentMissionTemplateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weekMissionViewModel = ViewModelProvider(this)[WeeklyMissionViewModel::class.java]
        _binding = FragmentMissionTemplateBinding.inflate(inflater, container, false)
        val root: View = binding.root
        weekMissionViewModel.missions.observe(
            viewLifecycleOwner,
            Observer {
                binding.recyclerView.setHasFixedSize(true)
                binding.recyclerView.layoutManager = LinearLayoutManager(context)
                binding.recyclerView.adapter = DailyMissionAdapter(
                    it,
                    object : DailyMissionAdapter.ListListener {
                        override fun onClickItem(tappedView: View, mission: Mission) {
                            // ポップアップ表示
                            val builder = AlertDialog.Builder(activity)
                            builder.setTitle(mission.title)
                                .setMessage("ミッションを完了しますか?")
                                .setPositiveButton("完了") { dialog, id ->
                                    // このボタンを押した時の処理を書きます。
                                    weekMissionViewModel.deleteMission(mission)
                                }
                                .setNegativeButton("キャンセル", null)
                                .show()
                        }
                    }
                )
            }
        )
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
