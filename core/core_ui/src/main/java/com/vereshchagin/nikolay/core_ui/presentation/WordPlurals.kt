package com.vereshchagin.nikolay.core_ui.presentation

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder

fun Fragment.getPluralsString(@PluralsRes res: Int, number: Int): String {
    return requireContext().getPluralsString(res, number)
}

fun AdapterDelegateViewBindingViewHolder<*, *>.getPluralsString(
    @PluralsRes res: Int,
    number: Int
): String {
    return context.getPluralsString(res, number)
}

fun Context.getPluralsString(@PluralsRes res: Int, number: Int): String {
    return resources.getQuantityString(res, number, number)
}