package buu.example.myapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
        Log.i("LibraryFragment", "onCreateView called")
        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("LibraryFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LibraryFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("LibraryFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("LibraryFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("LibraryFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("LibraryFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("LibraryFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LibraryFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("LibraryFragment", "onDetach called")
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
