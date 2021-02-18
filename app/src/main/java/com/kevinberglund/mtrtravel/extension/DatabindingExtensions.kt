package com.kevinberglund.mtrtravel.extension

import android.database.DatabaseUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T: ViewDataBinding> View.inflate(layoutId: Int, parent: ViewGroup, attachToRoot: Boolean = false): T =
    DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, attachToRoot)

fun <T : ViewDataBinding> ViewGroup.inflateInside(layoutId: Int, attachToRoot: Boolean = false): T =
    DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, this, attachToRoot)
