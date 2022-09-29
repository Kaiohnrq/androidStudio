package com.example.todolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentFormBinding
import com.example.todolist.databinding.FragmentListBinding
import com.example.todolist.model.Categoria

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    binding = FragmentFormBinding.inflate(layoutInflater, container, false)

    mainViewModel.listCategoria()

    mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
        response -> Log.d("Requisicao", response.body().toString())
        spinnerCategoria(response.body())
    }

    binding.buttonSalvar.setOnClickListener {
            findNavController().navigate(R.id.listFragment)
        }

    binding.buttonCancelar.setOnClickListener {
            findNavController().navigate(R.id.listFragment)
        }

        return binding.root
    }

    fun spinnerCategoria(listCategoria: List<Categoria>?){
        if(listCategoria != null){
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                listCategoria
            )
        }
    }

}