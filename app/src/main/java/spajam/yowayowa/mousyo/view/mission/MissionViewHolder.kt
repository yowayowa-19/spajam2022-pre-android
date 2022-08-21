package spajam.yowayowa.mousyo.view.mission

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import spajam.yowayowa.mousyo.R

class MissionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title: TextView
    init {
        title = itemView.findViewById(R.id.title)
    }
}
