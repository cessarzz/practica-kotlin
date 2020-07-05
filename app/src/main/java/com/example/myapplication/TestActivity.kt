package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val u = intent.getStringExtra("usuario")
        var usuario : Usuario? = null
        if (u != null) {
            usuario = Gson().fromJson(u, Usuario::class.java)
            Log.d("gson", u)

            infon.text = "${usuario.nombre}\n${usuario.apellido}\n${usuario.edad}\n${usuario.email}"
        }
    }
}