package spajam.yowayowa.mousyo.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _usernameText = MutableLiveData<String>().apply {
        value = ""
    }
    val usernameText: LiveData<String>
        get() = _usernameText
    fun setUsername(text: String) {
        _usernameText.value = text
    }

    private val _passwordText = MutableLiveData<String>().apply {
        value = ""
    }
    val passwordText: LiveData<String>
        get() = _passwordText
    fun setPassword(text: String) {
        _passwordText.value = text
    }
}
