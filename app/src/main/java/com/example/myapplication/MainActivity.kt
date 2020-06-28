package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mySharedPreferences = MySharedPreferences(this)
        val user = mySharedPreferences.getKey(PerfilActivity.KEY_USUARIO)
        val pass = mySharedPreferences.getKey(PerfilActivity.KEY_PASSWORD)

        if (user == "none") {
            val intent = Intent(this, RegitroActivity::class.java)
            startActivity(intent)
        }

        btn_login_login.setOnClickListener { view ->
            if (user != "none" && item_login_user.text.toString() == user && item_login_password.text.toString() == pass) {
                val intent = Intent(this, PerfilActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Snackbar.make(view, "El usuario o la contraseña son incorrectos", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }

        btn_login_registrar.setOnClickListener {
            val intent = Intent(this, RegitroActivity::class.java)
            startActivity(intent)
        }

    }

}