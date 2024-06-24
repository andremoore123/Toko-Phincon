package com.id.tokophincon.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.id.tokophincon.ui.onboarding.OnBoardingObjectFragment

class OnBoardingAdapter(fragment: Fragment, private val listOfImage: List<Int>) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = listOfImage.size

    override fun createFragment(position: Int): Fragment = OnBoardingObjectFragment.newInstance(
        listOfImage[position]
    )
}