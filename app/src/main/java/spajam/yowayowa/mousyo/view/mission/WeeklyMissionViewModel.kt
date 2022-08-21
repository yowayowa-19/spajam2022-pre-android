package spajam.yowayowa.mousyo.view.mission

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import spajam.yowayowa.mousyo.model.Mission

class WeeklyMissionViewModel : ViewModel() {
    // Dailyコードそのまま...
    private val _missions: MutableLiveData<List<Mission>> by lazy {
        MutableLiveData<List<Mission>>().also {
            it.value = loadMissionsMoq()
        }
    }
    val missions: LiveData<List<Mission>>
        get() = _missions
    private fun loadMissionsMoq(): List<Mission> {
        val mission1 = Mission(1, "エアコンを7時間つける", "", 1, 0, false)
        val mission2 = Mission(2, "昼間に電気を10時間つける", "", 5, 0, false)
        return listOf(mission1, mission2)
    }
    fun deleteMission(target: Mission) {
        val mutableList = mutableListOf<Mission>()
        _missions.value?.forEach {
            mutableList.add(it)
        }
        mutableList.remove(target)
        _missions.value = mutableList
    }
}
