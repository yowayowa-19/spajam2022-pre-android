package spajam.yowayowa.mousyo.view.login

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import spajam.yowayowa.mousyo.api.response.UserInfo
import spajam.yowayowa.mousyo.repository.AccountRepository
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LoginViewModel(
    private val accountRepository: AccountRepository,
) : ViewModel() {
    class Factory(
        private val accountRepository: AccountRepository
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(accountRepository) as T
        }
    }
    private val _userName = MutableLiveData<String>().apply {
        value = ""
    }
    val userName: LiveData<String>
        get() = _userName
    fun setUsername(text: String) {
        _userName.value = text
    }

    private val _totalPoints = MutableLiveData<Int>().apply {
        value = 0
    }
    val totalPoints: LiveData<Int>
        get() = _totalPoints
    fun setTotalPoints(totalPoints: Int) {
        _totalPoints.value = totalPoints
    }

    private val _passwordText = MutableLiveData<String>().apply {
        value = ""
    }
    val passwordText: LiveData<String>
        get() = _passwordText
    fun setPassword(text: String) {
        _passwordText.value = text
    }

    private val _loginFailure = MutableLiveData<Boolean>().apply {
        value = false
    }
    val loginFailure: LiveData<Boolean>
        get() = _loginFailure
    fun loginFailed() {
        _loginFailure.value = true
    }

    suspend fun login(): Int {
        return suspendCoroutine { continuation ->
            viewModelScope.launch(Dispatchers.IO) {
                kotlin.runCatching {
                    accountRepository.login(
                        _userName.value.toString(),
                        _passwordText.value.toString(),
                    )
                }.onSuccess {
                    continuation.resume(it.body()?.user_id ?: -1)
                }.onFailure { e ->
                    println("Failure $e")
                    continuation.resume(-1)
                }
            }
        }
    }

    suspend fun getUserInfo(userId: Int): UserInfo {
        return suspendCoroutine { continuation ->
            viewModelScope.launch(Dispatchers.IO) {
                kotlin.runCatching {
                    accountRepository.getUserInfo(
                        userId
                    )
                }.onSuccess {
                    continuation.resume(it.body() ?: UserInfo("", 0))
                }.onFailure { e ->
                    Log.e("getUserInfo", "Failure: $e")
                    continuation.resume(UserInfo("", 0))
                }
            }
        }
    }
}
