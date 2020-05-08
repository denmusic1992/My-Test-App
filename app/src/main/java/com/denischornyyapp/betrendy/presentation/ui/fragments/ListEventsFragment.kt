package com.denischornyyapp.betrendy.presentation.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.denischornyyapp.betrendy.R
import com.denischornyyapp.betrendy.databinding.FragmentListEventsBinding
import com.denischornyyapp.betrendy.framework.viewmodel.ListEventsViewModel

/**
 * A simple [Fragment] subclass.
 */
class ListEventsFragment : Fragment() {


    private var _binding: FragmentListEventsBinding? = null
    private val binding: FragmentListEventsBinding get() = _binding!!
    private lateinit var viewModel: ListEventsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.signout -> viewModel.signOut()
        }
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListEventsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListEventsViewModel::class.java)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.signout.observe(viewLifecycleOwner, Observer {
            val action = ListEventsFragmentDirections.actionListEventsFragmentToLoginFragment()
            findNavController().navigate(action)
        })

        viewModel.events.observe(viewLifecycleOwner, Observer {

        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
