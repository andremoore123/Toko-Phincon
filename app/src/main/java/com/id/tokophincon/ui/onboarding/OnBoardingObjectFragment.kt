package com.id.tokophincon.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.id.tokophincon.databinding.FragmentOnBoardingObjectBinding

class OnBoardingObjectFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingObjectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingObjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            bundle.getInt(IMAGE_ID).let {
                binding.root.setImageResource(it)
            }
        }
    }

    companion object {
        private const val IMAGE_ID = "imageID"
        fun newInstance(@DrawableRes imageId: Int): OnBoardingObjectFragment {
            return OnBoardingObjectFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMAGE_ID, imageId)
                }
            }
        }
    }

}