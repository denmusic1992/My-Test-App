package com.denischornyyapp.betrendy.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.denischornyyapp.betrendy.databinding.FragmentRegisterBinding
import com.denischornyyapp.betrendy.framework.utils.PopupUtils
import com.denischornyyapp.betrendy.framework.viewmodel.RegisterViewModel
import com.denischornyyapp.domain_layer.data.User

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding: FragmentRegisterBinding get() = _binding!!
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        binding.buttonRegister.setOnClickListener { registerUser() }

        observeViewModel()
    }

    /**
     * добавляем observer
     */
    private fun observeViewModel() {
        viewModel.isRegistered.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if(it) {
                PopupUtils.makeLongSnack(binding.root, "Registeration successfull!")
                findNavController().popBackStack()
            }
        })
    }

    /**
     * Регистрация пользователя
     */
    private fun registerUser() {
        // сначала проверка на забитые данные
        if (validation()) {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            val firstName = binding.editTextFirstName.text.toString()
            val lastName = binding.editTextLastName.text.toString()
            val middleName = binding.editTextMiddleName.text.toString()
            val newUser = User(
                firstName = firstName,
                lastName = lastName,
                middleName = middleName,
                username = username,
                passwordHash = password.hashCode()
            )
            viewModel.registerNewUser(newUser)
        }
    }

    /**
     * Проверка на валидность
     */
    private fun validation(): Boolean {
        binding.textInputUsername.error = null
        binding.textInputPassword.error = null
        binding.textInputConfirmPassword.error = null
        binding.textInputFirstName.error = null
        binding.textInputLastName.error = null


        var success = true
        // username
        if (binding.editTextUsername.text.toString().isEmpty()) {
            binding.textInputUsername.error = "Please enter username"
            success = false
        }

        if (binding.editTextPassword.text.toString().isEmpty()) {
            binding.textInputPassword.error = "Please enter password"
            success = false
        }

        if (binding.editTextConfirmPassword.text.toString().isEmpty() ||
            binding.editTextConfirmPassword.text.toString() != binding.editTextPassword.text.toString()
        ) {
            binding.textInputConfirmPassword.error = "Passwords are not the same"
            success = false
        }

        if (binding.editTextFirstName.text.toString().isEmpty()) {
            binding.textInputFirstName.error = "Please enter your First name"
            success = false
        }

        if (binding.editTextLastName.text.toString().isEmpty()) {
            binding.textInputLastName.error = "Please enter your Last name"
        }

        return success
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}
