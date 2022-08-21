package spajam.yowayowa.mousyo.view.mission

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 2

class TabPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DailyMissionFragment()
            1 -> WeeklyMissionFragment()
            else -> WeeklyMissionFragment()
        }
    }
}
