package buu.example.myapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.navigation.findNavController

import buu.example.myapp.databinding.FragmentLibraryBinding


class LibraryFragment : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLibraryBinding>(inflater, R.layout.fragment_library,container,false)


        binding.BookImage1.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_libraryFragment_to_detailFragment)
        }


        return binding.root
    }



}
