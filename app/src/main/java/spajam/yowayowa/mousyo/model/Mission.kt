package spajam.yowayowa.mousyo.model

data class Mission(
    val mission_id: Int,
    val title: String,
    val describe: String,
    val point: Int,
    val current_point: Int,
    val status: Boolean,
)
