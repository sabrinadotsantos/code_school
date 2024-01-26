package com.example.vsconnect_kotlin.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vsconnect_kotlin.R
import com.example.vsconnect_kotlin.models.Servico

//arquivo responsavel por passar os dados para o recyclerview

class ListaServicoAdapter(
    private val context: Context,
    private val listaServicos: List<Servico>

) : RecyclerView.Adapter<ListaServicoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        //funcao responsavel por chamar e atribuir valores para as views do item da RecyclerView
        fun vincularDadosNoItem(servico: Servico){
            val tituloServico = itemView.findViewById<TextView>(R.id.nomeServico)
            tituloServico.text = servico.titulo

            val propostaServico = itemView.findViewById<TextView>(R.id.valorServico)
            propostaServico.text = servico.proposta

            val descricaoServico = itemView.findViewById<TextView>(R.id.descricaoServico)
            descricaoServico.text = servico.descricao
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaServicoAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListaServicoAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}