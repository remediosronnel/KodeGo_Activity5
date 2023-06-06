package com.remedios.activity5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.remedios.activity5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private var auth = FirebaseAuth.getInstance()
    lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button3.setOnClickListener {

                var email:String = binding.TEEmail.text.toString()
                var password:String = binding.TEPassword.text.toString()

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                           Toast.makeText(this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()

                        }
                    }

        }

    }
}

