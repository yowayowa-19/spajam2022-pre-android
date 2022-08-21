package spajam.yowayowa.mousyo.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import spajam.yowayowa.mousyo.model.Mission

interface MissionAPI {
    @GET("/missions")
    suspend fun getMission(@Query("user_id")user_id: Int): Response<List<Mission>>
}
