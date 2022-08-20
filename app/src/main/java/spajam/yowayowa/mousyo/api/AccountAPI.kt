package spajam.yowayowa.mousyo.api

import retrofit2.http.Field
import retrofit2.http.POST

interface AccountAPI {
    @POST("users/register/")
    suspend fun register(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String,
    ): Int
}
