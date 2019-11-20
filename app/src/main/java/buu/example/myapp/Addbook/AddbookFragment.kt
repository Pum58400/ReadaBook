package buu.example.myapp.Addbook

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.example.myapp.databinding.FragmentDetailBinding
import buu.example.myapp.databinding.FragmentLibraryBinding
import java.time.Instant
import android.R.attr.data
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import buu.example.myapp.R
import buu.example.myapp.database.Roomdb
import buu.example.myapp.databinding.FragmentAddbookBinding
import com.google.android.material.snackbar.Snackbar


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [detailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [detailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddbookFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentAddbookBinding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_addbook, container, false)
        binding.buttonCancel.setOnClickListener {
            it.findNavController().navigate(R.id.action_addbookFragment_to_showbookFragment)
        }

        val application = requireNotNull(this.activity).application
        val dataSource = Roomdb.getInstance(application).gymDao
        val viewmodelfactory = AddbookViewModelFactory(dataSource, application)
        val viewModel = ViewModelProviders.of(this, viewmodelfactory)
            .get(AddbookViewModel::class.java)

        viewModel.gotoShowbook.observe(this, Observer {
            if (it) {
                findNavController().navigate(
                    AddbookFragmentDirections.actionAddbookFragmentToShowbookFragment()
                )
            }
        })

        viewModel.showSnackBarEvent.observe(this, Observer {
            Snackbar.make(
                activity!!.findViewById(android.R.id.content),
                "Please input correct informations.",
                Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()
        })


        // Inflate the layout for this fragment

        binding.addbookViewModel = viewModel
        return binding.root

    }




}