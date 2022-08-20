package spajam.yowayowa.mousyo.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserInterestSettingsViewModel : ViewModel() {
    private val _haveCar = MutableLiveData<Boolean>().apply {
        value = false
    }
    val haveCar: LiveData<Boolean>
        get() = _haveCar
    fun setHaveCar(boolean: Boolean) {
        _haveCar.value = boolean
    }
    private val _haveAircon = MutableLiveData<Boolean>().apply {
        value = false
    }
    val haveAircon: LiveData<Boolean>
        get() = _haveAircon
    fun setHaveAircon(boolean: Boolean) {
        _haveAircon.value = boolean
    }
    private val _haveTv = MutableLiveData<Boolean>().apply {
        value = false
    }
    val haveTv: LiveData<Boolean>
        get() = _haveTv
    fun setHaveTv(boolean: Boolean) {
        _haveTv.value = boolean
    }
}
