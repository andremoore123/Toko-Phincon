package com.id.tokophincon.ui.onboarding

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.id.tokophincon.base.BaseFragment
import com.id.tokophincon.databinding.FragmentOnBoardingBinding
import com.id.tokophincon.ui.adapter.OnBoardingAdapter
import com.id.tokophincon.util.Utils.onBoardDrawableList

class OnBoardingFragment : BaseFragment<FragmentOnBoardingBinding, ViewModel>(
    FragmentOnBoardingBinding::inflate
) {
    override fun initView() {
        val onBoardingAdapter = OnBoardingAdapter(this, onBoardDrawableList)
        with(binding) {
            onBoardViewPager2.adapter = onBoardingAdapter
            TabLayoutMediator(tabLayout, onBoardViewPager2) { _, _ ->
            }.attach()
        }
    }

    override fun initListener() =
        with(binding) {
            binding.onBoardViewPager2.run {
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (position == onBoardDrawableList.size - 1) {
                            nextButton.visibility = View.GONE
                        } else {
                            nextButton.visibility = View.VISIBLE
                            nextButton.setOnClickListener {
                                setCurrentItem(currentItem + 1, true)
                            }
                        }
                    }
                })
            }

            joinNowButton.setOnClickListener {

            }
        }

    private fun navigateToAuthScreen() {
        // TODO(): Create Navigation to Auth Nav
    }
}