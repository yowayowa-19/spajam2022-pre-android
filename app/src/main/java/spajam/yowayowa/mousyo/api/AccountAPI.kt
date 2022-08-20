package spajam.yowayowa.mousyo.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import spajam.yowayowa.mousyo.api.response.UserId

interface AccountAPI {
    @POST("users/register")
    suspend fun register(@Body credential: Credential)

    @POST("users/login")
    suspend fun login(@Body credential: Credential): Response<UserId>

    data class Credential(val email: String, val user_name: String, val password: String)
}
