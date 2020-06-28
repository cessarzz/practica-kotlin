package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_regitro.*

class RegitroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regitro)

        if (intent.getStringExtra("action") == "editar") {
            cargarDatos()
            this.title = "EDITAR PERFIL"
        } else {
            this.title = "REGRISTAR PERFIL"
        }

        btn_registro_guardar.setOnClickListener {
            guardar()
            finish()
        }
    }

    private fun cargarDatos () {
        val mySharedPreferences = MySharedPreferences(this)
        item_regidtro_user.setText(mySharedPreferences.getKey(PerfilActivity.KEY_USUARIO))
        item_regidtro_password.setText(mySharedPreferences.getKey(PerfilActivity.KEY_PASSWORD))
        item_regidtro_nombre.setText(mySharedPreferences.getKey(PerfilActivity.KEY_NOMBRE))
        item_regidtro_apellido.setText(mySharedPreferences.getKey(PerfilActivity.KEY_APELLIDO))
        item_regidtro_dni.setText(mySharedPreferences.getKey(PerfilActivity.KEY_DNI))
        item_regidtro_direccion.setText(mySharedPreferences.getKey(PerfilActivity.KEY_DIRECCION))
    }

    private fun guardar() {
        val mySharedPreferences = MySharedPreferences(this)
        mySharedPreferences.put(PerfilActivity.KEY_USUARIO, item_regidtro_user.text.toString())
        mySharedPreferences.put(PerfilActivity.KEY_PASSWORD, item_regidtro_password.text.toString())
        mySharedPreferences.put(PerfilActivity.KEY_NOMBRE, item_regidtro_nombre.text.toString())
        mySharedPreferences.put(PerfilActivity.KEY_APELLIDO, item_regidtro_apellido.text.toString())
        mySharedPreferences.put(PerfilActivity.KEY_DNI, item_regidtro_dni.text.toString())
        mySharedPreferences.put(PerfilActivity.KEY_DIRECCION, item_regidtro_direccion.text.toString())
        mySharedPreferences.save()
    }

}