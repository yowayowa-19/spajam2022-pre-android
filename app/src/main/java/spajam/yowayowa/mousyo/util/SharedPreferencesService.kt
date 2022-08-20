package spajam.yowayowa.mousyo.util

import android.content.Context

class SharedPreferencesService(private val context: Context) {
    companion object {
        private const val FILE_NAME = "Preferences"
        private const val KEY_USER_ID = "user_id"
        /*
        private const val KEY_SHOWN_FIRST_TUTORIAL = "shown_first_tutorial"
        private const val KEY_LAST_TAP_TIME_MILLIS = "last_tap_time_millis"
        private const val KEY_TAP_COUNT = "tap_count"
         */
    }
    private val sharedPreferences by lazy {
        context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    }

    fun getUserId(): Int = sharedPreferences.getInt(KEY_USER_ID, -1)
    fun saveUserId(userId: Int) {
        sharedPreferences.edit()
            .putInt(KEY_USER_ID, userId)
            .apply()
    }
    /* ユーティリティ使用例
    fun isShownFirstTutorial():Boolean = sharedPreferences.getBoolean(KEY_SHOWN_FIRST_TUTORIAL,false)
    fun saveShownFirstTutorial(){
        sharedPreferences.edit()
            .putBoolean(KEY_SHOWN_FIRST_TUTORIAL,true)
            .apply()
    }

    fun getTapCount(): Int = sharedPreferences.getInt(KEY_TAP_COUNT,0)
    fun saveTapCount(count:Int){
        sharedPreferences.edit()
            .putInt(KEY_TAP_COUNT,count)
            .apply()
    }

    fun getLastTapTimeMillis():Long = sharedPreferences.getLong(KEY_LAST_TAP_TIME_MILLIS,0L)
    fun saveLastTapTimeMillis(){
        val now = Calendar.getInstance().timeInMillis
        sharedPreferences.edit()
            .putLong(KEY_LAST_TAP_TIME_MILLIS,now)
            .apply()
    }
     */
}
