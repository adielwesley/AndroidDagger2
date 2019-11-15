package com.example.tools.features.jokes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tools.MainActivity

import com.example.tools.R
import com.example.tools.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_jokes.*
import javax.inject.Inject

class JokesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel : JokesViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity as MainActivity).jokesComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = JokesAdapter()
        jokesList.adapter = adapter
        jokesList.layoutManager = LinearLayoutManager(activity)

        viewModel.jokes.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

    }
}
