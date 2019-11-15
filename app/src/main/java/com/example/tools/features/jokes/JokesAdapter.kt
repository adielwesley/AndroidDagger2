package com.example.tools.features.jokes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tools.R
import com.example.tools.features.model.Joke
import kotlinx.android.synthetic.main.joke_item.view.*

class JokesAdapter(private var list : MutableList<Joke> = mutableListOf()) : RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {

    fun setData(list : MutableList<Joke>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.joke_item, parent, false)
        return JokesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        val joke = list[position]
        holder.bindData(joke)
    }


    class JokesViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bindData(joke: Joke) {
            view.setup.text = joke.setup
            view.punchline.text = joke.punchline
        }
    }

}