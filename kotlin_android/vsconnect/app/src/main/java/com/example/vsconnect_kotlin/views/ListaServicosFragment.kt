package com.example.vsconnect_kotlin.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vsconnect_kotlin.adapters.ListaServicoAdapter
import com.example.vsconnect_kotlin.apis.EndpointInterface
import com.example.vsconnect_kotlin.apis.RetrofitConfig
import com.example.vsconnect_kotlin.databinding.FragmentListaServicosBinding
import com.example.vsconnect_kotlin.models.Servico
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListaServicosFragment : Fragment() {

    private val clienteRetrofit = RetrofitConfig.obterInstanciaRetrofit()

    private val endpoints = clienteRetrofit.create(EndpointInterface::class.java)

    private var _binding: FragmentListaServicosBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListaServicosBinding.inflate(inflater, container, false)

        val root: View = binding.root

        //organiza os itens da Recycler em ordem vertical, sendo um debaixo do outro
        binding.recycleServicos.layoutManager = LinearLayoutManager(requireContext())

        endpoints.listarServicos().enqueue(object : Callback<List<Servico>>{
            override fun onResponse(call: Call<List<Servico>>, response: Response<List<Servico>>) {
                val servicos = response .body()
                binding.recycleServicos.adapter = servicos?.let { ListaServicoAdapter(requireContext(), it) }
            }

            override fun onFailure(call: Call<List<Servico>>, t: Throwable) {
                println("Falha na requisição: ${t.message}")

            }

        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}