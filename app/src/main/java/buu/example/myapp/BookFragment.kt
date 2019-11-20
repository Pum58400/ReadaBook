package buu.example.myapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.example.myapp.databinding.FragmentBookBinding
import buu.example.myapp.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class BookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentBookBinding>(inflater, R.layout.fragment_book,container,false)
        binding.BACKBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_bookFragment_to_libraryFragment)
        }




        return binding.root
    }


}
