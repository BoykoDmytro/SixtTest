package com.sixt.test.presentation.adapters

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sixt.test.R
import com.sixt.test.presentation.ui.home.fragment.CarListFragment
import com.sixt.test.presentation.ui.home.fragment.MapFragment

class HomeVPAdapter(private val context: Context, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = arrayListOf(
        CarListFragment.newInstance(),
        MapFragment.newInstance()
    )

    @StringRes
    private val fragmentNames = arrayListOf(R.string.cars, R.string.map)

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? =
        context.getString(fragmentNames[position])
}