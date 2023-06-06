package com.remedios.activity5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.remedios.activity5.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animationUI()

        auth = FirebaseAuth.getInstance()
        binding.button.setOnClickListener {

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
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {

                            Toast.makeText(this, "Welcome!!!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(applicationContext, FirstActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {

                            Toast.makeText(this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()


            }}


        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun animationUI(){
        Handler(Looper.getMainLooper()).postDelayed({
            binding.lottieAnimationView.visibility = View.VISIBLE
            binding.lottieAnimationView.loop(true)
        }, 9000000)
    }
}


