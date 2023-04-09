package com.graymandev.sapp.view.sign_up

import android.content.ContentValues.TAG
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.chetantuteja.easybinding.BindingFragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.graymandev.sapp.MainActivity
import com.graymandev.sapp.R
import com.graymandev.sapp.databinding.FragmentSignUpBinding


class SignUpFragment : BindingFragment<FragmentSignUpBinding>() {

    private companion object {
        const val MIN_PASSWORD_LENGTH = 8
    }

    private lateinit var auth: FirebaseAuth

    //private val signUpViewModel: SignUpViewModel by viewModels()

    override fun init() {

        //initUI()

        val items = arrayOf("Male", "Female", "Other")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, items)
        val autoCompleteTextView =
            requireView().findViewById<AutoCompleteTextView>(R.id.actv_orientation)
        autoCompleteTextView.setAdapter(adapter)

        auth = Firebase.auth

        // Click event to the Sign-In button
        binding.btnSignUpUser.setOnClickListener {
            registerUser()
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignUpBinding {
        return FragmentSignUpBinding.inflate(inflater, container, false)


    }

    /*
    private fun initUI() {
        initListeners()
        initObservers()
    }

    private fun initListeners() {

        binding.etName.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etName.onTextChanged { onFieldChanged() }

        binding.etEmail.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etEmail.onTextChanged { onFieldChanged() }

        binding.etNickname.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etNickname.onTextChanged { onFieldChanged() }

        binding.etAge.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etAge.onTextChanged { onFieldChanged() }

        binding.tilOrientation.editText?.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.tilOrientation.editText?.onTextChanged { onFieldChanged() }

        binding.etEmail.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etEmail.onTextChanged { onFieldChanged() }

        binding.etCellPhoneNumber.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etCellPhoneNumber.onTextChanged { onFieldChanged() }

        binding.etPasswordSignUp.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etPasswordSignUp.onTextChanged { onFieldChanged() }

        binding.etConfirmPasswordSignUp.setOnFocusChangeListener { _, hasFocus -> onFieldChanged(hasFocus) }
        binding.etConfirmPasswordSignUp.onTextChanged { onFieldChanged() }

        with(binding) {
            btnSignUpUser.setOnClickListener {
                it.dismissKeyboard()
                signUpViewModel.onSignUpSelected(
                    UserSignUp(
                        name = binding.etName.text.toString(),
                        surname = binding.etSurname.text.toString(),
                        nickname = binding.etNickname.text.toString(),
                        age = binding.etAge.text.toString(),
                        orientation = binding.tilOrientation.editText?.text.toString(),
                        email = binding.etEmail.text.toString(),
                        mobile = binding.etCellPhoneNumber.text.toString(),
                        password = binding.etPasswordSignUp.text.toString(),
                        passwordConfirmation = binding.etConfirmPasswordSignUp.text.toString()
                    )
                )
            }
        }
    }

    private fun onFieldChanged(hasFocus: Boolean = false) {
        if (!hasFocus) {
            signUpViewModel.onFieldsChanged(
                UserSignUp(
                    name = binding.etName.text.toString(),
                    surname = binding.etSurname.text.toString(),
                    nickname = binding.etNickname.text.toString(),
                    age = binding.etAge.text.toString(),
                    orientation = binding.tilOrientation.editText?.text.toString(),
                    email = binding.etEmail.text.toString(),
                    mobile = binding.etCellPhoneNumber.text.toString(),
                    password = binding.etPasswordSignUp.text.toString(),
                    passwordConfirmation = binding.etConfirmPasswordSignUp.text.toString()
                )
            )
        }
    }

    private fun initObservers() {
        signUpViewModel.navigateToVerifyEmail.observe(this) {
            it.getContentIfNotHandled()?.let {
                goToVerifyEmail()
            }
        }

        signInViewModel.navigateToLogin.observe(this) {
            it.getContentIfNotHandled()?.let {
                goToLogin()
            }
        }

        lifecycleScope.launchWhenStarted {
            signInViewModel.viewState.collect { viewState ->
                updateUI(viewState)
            }
        }

        signInViewModel.showErrorDialog.observe(this) { showError ->
            if (showError) showErrorDialog()
        }
    }

     */


    private fun enterToMainActivity(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(
                requireContext(),
                "Error when trying to go to the main page.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun registerUser() {

        val name: String = binding.etName.text.toString().trim { it <= ' ' }
        val surname: String = binding.etSurname.text.toString().trim { it <= ' ' }
        val nickname: String = binding.etNickname.text.toString().trim { it <= ' ' }
        val age: String = binding.etAge.text.toString().trim { it <= ' ' }
        val orientation: String = binding.tilOrientation.editText.toString()
        val email: String = binding.etEmail.text.toString().trim { it <= ' ' }
        val phoneNumber: String = binding.etCellPhoneNumber.text.toString().trim { it <= ' ' }
        val password: String = binding.etPasswordSignUp.text.toString().trim { it <= ' ' }
        val confirmPassword: String =
            binding.etConfirmPasswordSignUp.text.toString().trim { it <= ' ' }

        if (validateForm(
                name,
                surname,
                nickname,
                age,
                orientation,
                email,
                phoneNumber,
                password,
                confirmPassword
            )
        ) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        FirestoreClass().registerUser(requireContext(), user)
                        //enterToMainActivity(user)
                        Toast.makeText(
                            context,
                            "You have successfully registered.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val exception = task.exception
                        if (exception is FirebaseAuthInvalidCredentialsException) {
                            // El correo electrónico proporcionado no es válido
                            showErrorSnackBar("The email address is not valid.")
                        } else if (exception is FirebaseAuthUserCollisionException) {
                            // El correo electrónico ya está en uso por otro usuario
                            showErrorSnackBar("The email address is already in use by another account.")
                        } else if (exception is FirebaseAuthWeakPasswordException) {
                            // La contraseña no cumple con los requisitos de seguridad
                            showErrorSnackBar("The password is too weak.")
                        } else {
                            // Otro error ocurrió
                            showErrorSnackBar("Authentication failed.")
                        }
                    }
                }

        }
    }

    private fun validateForm(
        name: String,
        surname: String,
        nickname: String,
        age: String,
        orientation: String,
        email: String,
        phoneNumber: String,
        password: String,
        repeatPassword: String
    ): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter name.")
                false
            }
            TextUtils.isEmpty(surname) -> {
                showErrorSnackBar("Please enter surname.")
                false
            }
            TextUtils.isEmpty(nickname) -> {
                showErrorSnackBar("Please enter nickname.")
                false
            }
            TextUtils.isEmpty(age) -> {
                showErrorSnackBar("Please enter age.")
                false
            }
            TextUtils.isEmpty(orientation) -> {
                showErrorSnackBar("Please enter orientation.")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter email.")
                false
            }
            TextUtils.isEmpty(phoneNumber) -> {
                showErrorSnackBar("Please enter phone number.")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter password.")
                false
            }
            TextUtils.isEmpty(repeatPassword) -> {
                showErrorSnackBar("Please confirm password.")
                false
            }
            else -> {
                true
            }
        }
    }

    private fun showErrorSnackBar(message: String) {
        val myButton = binding.btnSignUpUser

        val snackBar = Snackbar.make(
            myButton,
            message,
            Snackbar.LENGTH_SHORT
        )
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(
            ContextCompat.getColor(requireContext(), R.color.md_theme_light_error)
        )
        snackBar.show()
    }

    private fun showSnackBar(message: String) {
        val myButton = binding.btnSignUpUser

        val snackBar = Snackbar.make(
            myButton,
            message,
            Snackbar.LENGTH_SHORT
        )
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(
            ContextCompat.getColor(requireContext(), R.color.md_theme_light_error)
        )
        snackBar.show()
    }

    private fun isValidOrEmptyEmail(email: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.isEmpty()

    private fun isValidOrEmptyPassword(password: String, passwordConfirmation: String): Boolean =
        (password.length >= MIN_PASSWORD_LENGTH && password == passwordConfirmation) || password.isEmpty() || passwordConfirmation.isEmpty()

}