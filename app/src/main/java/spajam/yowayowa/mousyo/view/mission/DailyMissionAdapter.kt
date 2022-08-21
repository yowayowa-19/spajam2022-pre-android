package spajam.yowayowa.mousyo.view.mission

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import spajam.yowayowa.mousyo.R
import spajam.yowayowa.mousyo.model.Mission

class DailyMissionAdapter(list: List<Mission>): RecyclerView.Adapter<MissionViewHolder>() {
    private val list  = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.mission_row,parent,false)
        return MissionViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
        val title = list.get(position).title
        holder.title.text = title
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}
