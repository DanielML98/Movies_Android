package com.danielml.movies

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view =  inflater.inflate(R.layout.fragment_sign_up, container, false)

    var signUpButton = view?.findViewById<Button>(R.id.signUpButton)
    signUpButton?.setOnClickListener {
      if (allFieldsAreFilled()) {
        if (passwordIsValid()) {
          Toast.makeText(view?.context, R.string.success_sign_up, Toast.LENGTH_LONG).show()
        } else {
          Toast.makeText(view?.context, R.string.invalid_password, Toast.LENGTH_LONG).show()
        }
      } else {
        Toast.makeText(view?.context, R.string.missing_fields, Toast.LENGTH_LONG).show()
      }
    }
    return view
  }

  private fun allFieldsAreFilled(): Boolean {
    val passwordTextField = view?.findViewById<TextInputEditText>(R.id.passwordTextField)
    val userNameTextField = view?.findViewById<TextInputEditText>(R.id.userNameTextField)
    val emailTextField = view?.findViewById<TextInputEditText>(R.id.emailTextField)
    return passwordTextField?.text?.isNotEmpty() ?: false  && userNameTextField?.text?.isNotEmpty() ?: false && emailTextField?.text?.isNotEmpty() ?: false
  }

  private fun passwordIsValid(): Boolean {
    val passwordTextField = view?.findViewById<TextInputEditText>(R.id.passwordTextField)
    val regex = Regex("^(?=.*[0-9])(?=.*[aA-zZ]).{6,32}\$")
    return regex.matches(passwordTextField?.text.toString())
  }

}