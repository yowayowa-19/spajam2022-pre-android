package spajam.yowayowa.mousyo.repository

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import spajam.yowayowa.mousyo.api.AccountAPI
import spajam.yowayowa.mousyo.api.response.UserId
import spajam.yowayowa.mousyo.api.response.UserInfo

class AccountRepository() {
    suspend fun register(userName: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://materialofmouse.aa0.netvolante.jp:25800/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofit.create(AccountAPI::class.java)
        service.register(AccountAPI.Credential("", userName, password))
    }
    suspend fun login(userName: String, password: String): Response<UserId> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://materialofmouse.aa0.netvolante.jp:25800/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofit.create(AccountAPI::class.java)
        return service.login(AccountAPI.Credential("", userName, password))
    }

    suspend fun getUserInfo(userId: Int): Response<UserInfo>{
        val retrofit = Retrofit.Builder()
                .baseUrl("http://materialofmouse.aa0.netvolante.jp:25800/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        val service = retrofit.create(AccountAPI::class.java)
        return service.getUserInfo(UserId(userId))
    }
}
