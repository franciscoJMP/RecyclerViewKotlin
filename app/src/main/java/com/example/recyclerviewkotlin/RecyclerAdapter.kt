package com.example.recyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewkotlin.Modelos.Clientes
import kotlinx.android.synthetic.main.item_clientes.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapter(
    val context: Context,
    val listaClientes:List<Clientes>,
    private val itemClickListener:OnClientesClickListener
):RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface OnClientesClickListener{
        fun onImageClick(nombre:String,apellidos: String,telefono: String,imagen: String)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ClientesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_clientes,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        if(holder is ClientesViewHolder){
            holder.bind(listaClientes[position],position)
        } else{
            throw IllegalArgumentException("Error viewHolder erroneo")

        }
    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }
    inner class ClientesViewHolder(itemView:View):BaseViewHolder<Clientes>(itemView){
        override fun bind(item: Clientes, position: Int) {
            Glide.with(context).load(item.imagen).into(itemView.img_cliente)
            itemView.tx_nombreApe.text=item.nombre+" "+item.apellidos
            itemView.tx_telefono.text="Telef: "+item.telefono



            itemView.img_cliente.setOnClickListener{
                itemClickListener.onImageClick(item.nombre,item.apellidos,item.telefono,item.imagen)
            }
        }
    }
}