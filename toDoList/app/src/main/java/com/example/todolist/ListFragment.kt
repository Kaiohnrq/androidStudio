package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.TarefaAdapter
import com.example.todolist.databinding.FragmentListBinding
import com.example.todolist.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    binding = FragmentListBinding.inflate(layoutInflater, container, false)



    val adapter = TarefaAdapter()
    binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
    binding.recyclerTarefa.adapter = adapter
    binding.recyclerTarefa.setHasFixedSize(true)


    binding.floatingActionButton.setOnClickListener {
        findNavController().navigate(R.id.action_listFragment_to_formFragment)
    }

    return binding.root
    }

}