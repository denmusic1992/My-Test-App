package com.denischornyyapp.betrendy.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.denischornyyapp.betrendy.R
import com.denischornyyapp.betrendy.databinding.FragmentNetworkBinding
import com.denischornyyapp.betrendy.framework.helpers.EventClickListener
import com.denischornyyapp.betrendy.framework.helpers.PostRecyclerViewAdapter
import com.denischornyyapp.betrendy.framework.utils.PopupUtils
import com.denischornyyapp.betrendy.framework.viewmodel.NetworkViewModel

/**
 * A simple [Fragment] subclass.
 */
class NetworkFragment : Fragment() {

    private var _binding: FragmentNetworkBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: NetworkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNetworkBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(NetworkViewModel::class.java)


        binding.recyclerViewPosts.adapter = PostRecyclerViewAdapter()

        observeViewModel()
        viewModel.getPosts()
    }

    private fun observeViewModel() {
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            (binding.recyclerViewPosts.adapter as PostRecyclerViewAdapter).submitList(it)
            binding.textViewPostTitle.text = getString(R.string.there_are_posts_from_server)
        })
    }

}
