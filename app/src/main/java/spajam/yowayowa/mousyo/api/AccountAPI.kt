package spajam.yowayowa.mousyo.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import spajam.yowayowa.mousyo.api.response.UserId
import spajam.yowayowa.mousyo.api.response.UserInfo

interface AccountAPI {
    @POST("users/register")
    suspend fun register(@Body credential: Credential)

    @POST("users/login")
    suspend fun login(@Body credential: Credential): Response<UserId>

    @GET("users/")
    suspend fun getUserInfo(@Query("user_id") userId: Int): Response<UserInfo>

    data class Credential(val email: String, val user_name: String, val password: String)
}
