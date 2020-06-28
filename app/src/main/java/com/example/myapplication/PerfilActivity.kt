package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    companion object {
        const val KEY_USUARIO = "user"
        const val KEY_PASSWORD = "pass"
        const val KEY_NOMBRE = "nombre"
        const val KEY_APELLIDO = "apellido"
        const val KEY_DNI = "dni"
        const val KEY_DIRECCION = "direccion"
    }

    data class User(val user:String?, val password:String?, val nombre:String?, val apellido:String?, val dni:String?, val direccion:String?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        this.title = "MY PERFIL"

        cargar()

        btn_perfil_editar.setOnClickListener {
            val intent = Intent(this, RegitroActivity::class.java)
            intent.putExtra("action", "editar")
            startActivity(intent)
        }
    }

    private fun cargar() {
        val user : User = createUser()

        item_perfil_nombre.text = user.nombre
        item_perfil_apellido.text = user.apellido
        item_perfil_dni.text = user.dni
        item_perfil_direccion.text = user.direccion
    }

    private fun createUser() : User {
        val mySharedPreferences = MySharedPreferences(this)
        val usuario = mySharedPreferences.getKey(KEY_USUARIO)
        val password = mySharedPreferences.getKey(KEY_PASSWORD)
        val nombre = mySharedPreferences.getKey(KEY_NOMBRE)
        val apellido = mySharedPreferences.getKey(KEY_APELLIDO)
        val dni = mySharedPreferences.getKey(KEY_DNI)
        val direccion = mySharedPreferences.getKey(KEY_DIRECCION)

        return User(usuario, password, nombre, apellido, dni, direccion)
    }

    override fun onResume() {
        super.onResume()
        cargar()
    }


}