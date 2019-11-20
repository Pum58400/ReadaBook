import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import buu.example.myapp.R
import buu.example.myapp.showbook.ShowbookAdapter
import buu.example.myapp.showbook.ShowbookViewModel
import buu.example.myapp.showbook.ShowbookViewModelFactory
import buu.example.myapp.database.Roomdb
import buu.example.myapp.databinding.FragmentShowbookBinding

class ShowbookFragment : Fragment() {
    private lateinit var binding: FragmentShowbookBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_showbook, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = Roomdb.getInstance(application).bookDao
        val viewmodelfactory = ShowbookViewModelFactory(dataSource, application)
        val viewModel = ViewModelProviders.of(this, viewmodelfactory)
            .get(ShowbookViewModel::class.java)

        val adapter = ShowbookAdapter()
        binding.RecycleList.adapter = adapter


        viewModel.book.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })


        return binding.root
    }
}