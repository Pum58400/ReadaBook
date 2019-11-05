package buu.example.myapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation

import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

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

        setHasOptionsMenu(true)
        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


}
