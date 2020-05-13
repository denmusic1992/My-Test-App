package com.denischornyyapp.betrendy.presentation.ui.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment


/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
open class BaseFragment : Fragment() {

    fun checkInternetConnectivity(): Boolean {
        val cm =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork.isConnectedOrConnecting
    }
}