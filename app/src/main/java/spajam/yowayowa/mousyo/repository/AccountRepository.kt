package spajam.yowayowa.mousyo.repository

import spajam.yowayowa.mousyo.api.AccountAPI

class AccountRepository(
    private val api: AccountAPI,
) {
    suspend fun register(userName: String, password: String): Boolean {
        val result = api.register("", userName, password)
        return result == 0
    }
}
