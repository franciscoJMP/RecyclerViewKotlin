package com.example.recyclerviewkotlin


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.recyclerviewkotlin.Modelos.Clientes
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity(), RecyclerAdapter.OnClientesClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cargarDatosJSon()


    }

    fun cargarDatosJSon() {
        var listaClientes = ArrayList<Clientes>()
        val url = "http://iesayala.ddns.net/franciscoJMP/jsonclientes.php"
        val queue = Volley.newRequestQueue(this)
        rv.layoutManager = LinearLayoutManager(this)
        rv.addItemDecoration((DividerItemDecoration(this, DividerItemDecoration.VERTICAL)))

        val stringRequest = StringRequest(Request.Method.GET, url, Response.Listener { response ->

            val jsonArray = JSONArray(response)


            for (i in 0 until jsonArray.length()) {

                val jsonObject = JSONObject(jsonArray.getString(i))
                val id = jsonObject.get("id").toString().toInt()
                val nombre = jsonObject.get("nombre").toString()
                val apellidos = jsonObject.get("apellidos").toString()
                val telefono = jsonObject.get("telefono").toString()
                val imagen = jsonObject.get("imagen").toString()

                var c = Clientes(id, nombre, apellidos, telefono, imagen)
                listaClientes.add(c)


            }

            if (listaClientes.size > 0) {
                rv.adapter = RecyclerAdapter(this, listaClientes, this)


            } else {
                Toast.makeText(applicationContext, listaClientes.size.toString(), Toast.LENGTH_LONG)
                    .show()

            }


        }, Response.ErrorListener {
            Toast.makeText(applicationContext, "Error en la conexion", Toast.LENGTH_LONG).show()
        })

        queue.add(stringRequest)

    }

    override fun onImageClick(nombre: String, apellidos: String, telefono: String, imagen: String) {
        val intent= Intent(this,MainActivity2::class.java)
        intent.putExtra("nombre",nombre)
        intent.putExtra("apellidos",apellidos)
        intent.putExtra("telefono",telefono)
        intent.putExtra("imagen",imagen)
        startActivity(intent)

    }


}