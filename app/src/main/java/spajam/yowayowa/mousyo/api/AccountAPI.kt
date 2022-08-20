package spajam.yowayowa.mousyo.api

import retrofit2.http.Body
import retrofit2.http.POST

interface AccountAPI {
    @POST("users/register")
    suspend fun register(@Body userInfo: UserInfo)
    data class UserInfo(val email: String, val user_name: String, val password: String)
}
