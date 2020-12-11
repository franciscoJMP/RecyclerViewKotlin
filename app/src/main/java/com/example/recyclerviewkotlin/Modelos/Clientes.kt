package com.example.recyclerviewkotlin.Modelos

class Clientes {
    var id: Int
    var nombre: String
    var apellidos:String
    var telefono:String
    var imagen:String

    constructor(id: Int, nombre: String, apellidos: String, telefono: String,imagen: String) {
        this.id = id
        this.nombre = nombre
        this.apellidos = apellidos
        this.telefono = telefono
        this.imagen=imagen
    }

}