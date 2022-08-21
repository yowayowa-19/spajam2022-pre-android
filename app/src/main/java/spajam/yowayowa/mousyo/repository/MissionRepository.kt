package spajam.yowayowa.mousyo.repository

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import spajam.yowayowa.mousyo.api.MissionAPI
import spajam.yowayowa.mousyo.model.Mission

class MissionRepository() {
    suspend fun getMission(user_id: Int): Response<List<Mission>> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://materialofmouse.aa0.netvolante.jp:25800/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofit.create(MissionAPI::class.java)
        return service.getMission(user_id)
    }
}
