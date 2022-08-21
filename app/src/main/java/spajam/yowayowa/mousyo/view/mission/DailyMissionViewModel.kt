package spajam.yowayowa.mousyo.view.mission

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import spajam.yowayowa.mousyo.model.Mission
import spajam.yowayowa.mousyo.repository.MissionRepository
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DailyMissionViewModel(
    private val missionRepository: MissionRepository,
) : ViewModel() {
    class Factory(
        private val missionRepository: MissionRepository
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DailyMissionViewModel(missionRepository) as T
        }
    }

    private val _missions: MutableLiveData<List<Mission>> by lazy {
        MutableLiveData<List<Mission>>().also {
            it.value = loadMissionsMoq()
        }
    }
    val missions: LiveData<List<Mission>>
        get() = _missions
    private fun loadMissionsMoq(): List<Mission> {
        val mission1 = Mission(1, "エアコンを1時間つける", "", 1, 0, false)
        val mission2 = Mission(2, "昼間に電気を5時間つける", "", 5, 0, false)
        return listOf(mission1, mission2)
    }
    fun setMissions(missions : List<Mission>){
        _missions.value = missions
    }
    suspend fun loadMissions(user_id:Int):List<Mission>{
        return suspendCoroutine { continuation ->
            viewModelScope.launch(Dispatchers.IO) {
                kotlin.runCatching {
                    missionRepository.getMission(user_id)
                }.onSuccess {
                    val result = mutableListOf<Mission>()
                    it.body()?.forEach {
                        result.add(it)
                    }
                    continuation.resume(result)
                }.onFailure { e ->
                    println("Failure $e")
                    continuation.resume(listOf())
                }
            }
        }
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
