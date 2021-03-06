package com.example.plantora.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.plantora.MainActivity
import com.example.plantora.MainActivity.Companion.email
import com.example.plantora.databinding.ActivityLogin2Binding

import com.example.plantora.R
import com.example.plantora.ui.notifications.NotificationsFragment
import com.example.plantora.ui.notifications.NotificationsViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = binding.username
        val password = binding.password
        val login = binding.login
        val loading = binding.loading
        //val error = binding.error
        val error = findViewById<TextView>(R.id.error)
        val notificationsViewModel : NotificationsViewModel by viewModels()
        var txtEmail : String
        var txtPassword : String
        txtEmail = ""
        email = txtEmail


//        button.setOnClickListener {
//        val intent = Intent(this, MainActivity::class.java)
//           startActivity(intent)
//       }

        login.setOnClickListener{
            txtEmail = username.text.toString()
            txtPassword = password.text.toString()
            email = txtEmail


            if(txtEmail.trim().isEmpty() ||txtPassword.trim().isEmpty()){
                error.text = "Veuillez remplir tous les champs"
                error.visibility = View.VISIBLE
            }
            else{
                val correctEmail = "estelle.ganot@gmail.com"
                val correctPassword = "plantora"
                email = txtEmail
                if(correctEmail.equals(txtEmail) && correctPassword.equals(txtPassword)){
//                    Toast.makeText(this, "Bienvenue sur Plantora", Toast.LENGTH_LONG).show()
//                    loading.visibility = View.VISIBLE
//                    val intentToNotificationsFragment = Intent(this, NotificationsFragment::class.java)
//                    intentToNotificationsFragment.putExtra("email",txtEmail)
//                    val fragment = NotificationsFragment()
//                    val bundle = Bundle()
//                    bundle.putString("email",txtEmail)
//                    fragment.arguments = bundle
//                    supportFragmentManager.beginTransaction().replace(R.id.tvMail,NotificationsFragment).commit()

                    email = txtEmail
                    loginViewModel.login(username.text.toString(), password.text.toString())
                }
                else{
                    error.text = "Email ou mot de passe incorrect"
                    error.visibility = View.VISIBLE
                }
            }
        }

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                //updateUiWithUser(loginResult.success)


            }
            setResult(Activity.RESULT_OK)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            //Complete and destroy login activity once successful
            finish()
        })

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged{
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            username.text.toString(),
                            password.text.toString()
                        )
                }
                false
            }

//            login.setOnClickListener {
//                loading.visibility = View.VISIBLE
//                loginViewModel.login(username.text.toString(), password.text.toString())
//            }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {

        // TODO : initiate successful logged in experience
        //Toast.makeText(
           // applicationContext,
           // "$welcome $displayName",
          //
       // ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}

