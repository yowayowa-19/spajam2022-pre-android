package spajam.yowayowa.mousyo.view

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import spajam.yowayowa.mousyo.repository.AccountRepository
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RegisterViewModel(
    private val accountRepository: AccountRepository,
) : ViewModel() {

    class Factory(
        private val accountRepository: AccountRepository
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel(accountRepository) as T
        }
    }

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

    suspend fun register(): Boolean {
        return suspendCoroutine { continuation ->
            viewModelScope.launch(Dispatchers.IO) {
                kotlin.runCatching {
                    accountRepository.register(
                        _usernameText.value.toString(),
                        _passwordText.value.toString(),
                    )
                }.onSuccess {
                    continuation.resume(true)
                }.onFailure { e ->
                    println("Failure $e")
                    continuation.resume(false)
                }
            }
        }
    }
}
