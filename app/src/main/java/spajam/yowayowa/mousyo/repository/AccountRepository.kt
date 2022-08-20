package spajam.yowayowa.mousyo.repository

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import spajam.yowayowa.mousyo.api.AccountAPI

class AccountRepository() {
    suspend fun register(userName: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://materialofmouse.aa0.netvolante.jp:25800/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofit.create(AccountAPI::class.java)
        service.register(AccountAPI.Credential("", userName, password))
    }
}
