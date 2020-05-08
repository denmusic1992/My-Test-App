package com.denischornyyapp.betrendy.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.denischornyyapp.betrendy.R
import com.denischornyyapp.betrendy.databinding.FragmentLoginBinding
import com.denischornyyapp.betrendy.framework.utils.PopupUtils
import com.denischornyyapp.betrendy.framework.viewmodel.LoginViewModel

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        if(viewModel.checkRegistration())
            findNavController().navigate(R.id.goto_home_screen)
        else {
            viewModel.error.value = false
            viewModel.loginComplete.value = false
            binding.buttonSignIn.setOnClickListener { loginUser() }
            binding.buttonSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }

        observeViewModel()
    }

    /**
     * здесь описаны все observer'ы используемой view model
     */
    private fun observeViewModel() {
        viewModel.loginComplete.observe(viewLifecycleOwner, Observer { success ->
            if(success) {
                val action = LoginFragmentDirections.gotoHomeScreen()
                findNavController().navigate(action)
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { err ->
            if(err)
                PopupUtils.makeShortSnack(binding.root, "Unable to login. Make sure you enter valid credentials!")
        })
    }

    /**
     * Пробуем логиниться
     */
    private fun loginUser() {
        val login = binding.editTextLogin.text.toString()
        val password = binding.editTextPassword.text.toString()

        if(login.isNotEmpty() && password.isNotEmpty()) {
            viewModel.loginUser(login, password.hashCode())
        }
        else {
            PopupUtils.makeShortSnack(binding.root, "Please fill all fields!")
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}
