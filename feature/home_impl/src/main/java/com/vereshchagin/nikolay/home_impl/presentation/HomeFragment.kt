package com.vereshchagin.nikolay.home_impl.presentation

import android.os.Bundle
import android.view.View
import com.vereshchagin.nikolay.core.presentation.BaseFragment
import com.vereshchagin.nikolay.home_impl.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}