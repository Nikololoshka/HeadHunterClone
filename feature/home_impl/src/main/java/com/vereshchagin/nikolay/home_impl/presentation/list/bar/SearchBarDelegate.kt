package com.vereshchagin.nikolay.home_impl.presentation.list.bar

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vereshchagin.nikolay.home_impl.databinding.SearchBarBinding
import com.vereshchagin.nikolay.home_impl.domain.model.HomeItem

fun searchBarDelegate(

) = adapterDelegateViewBinding<HomeItem.HomeSearchBar, HomeItem, SearchBarBinding>(
    viewBinding = { inflater, parent ->
        SearchBarBinding.inflate(inflater, parent, false)
    }
) {
}