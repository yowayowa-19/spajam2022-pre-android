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
import kotlinx.coroutines.runBlocking
import spajam.yowayowa.mousyo.databinding.FragmentMissionTemplateBinding
import spajam.yowayowa.mousyo.model.Mission
import spajam.yowayowa.mousyo.repository.MissionRepository
import spajam.yowayowa.mousyo.util.SharedPreferencesService

class DailyMissionFragment : Fragment() {

    private lateinit var dailyMissionViewModel: DailyMissionViewModel
    private var _binding: FragmentMissionTemplateBinding? = null
    private lateinit var sharedPreferencesService: SharedPreferencesService

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val missionRepository = MissionRepository()
        val factory = DailyMissionViewModel.Factory(missionRepository)

        sharedPreferencesService = SharedPreferencesService(requireContext())

        dailyMissionViewModel = ViewModelProvider(this, factory)[DailyMissionViewModel::class.java]
        _binding = FragmentMissionTemplateBinding.inflate(inflater, container, false)
        dailyMissionViewModel.missions.observe(
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
                                    dailyMissionViewModel.deleteMission(mission)
                                }
                                .setNegativeButton("キャンセル", null)
                                .show()
                        }
                    }
                )
            }
        )
        val root: View = binding.root
        val userid = sharedPreferencesService.getUserId()
        println("userid = $userid")
        runBlocking {
            kotlin.runCatching {
                val result = dailyMissionViewModel.loadMissions(userid)
                dailyMissionViewModel.setMissions(result)
            }.onSuccess { println(dailyMissionViewModel.missions.value) }.onFailure { e -> println(e) }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
