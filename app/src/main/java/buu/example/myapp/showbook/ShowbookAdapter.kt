package buu.example.myapp.showbook

import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.example.myapp.R
import buu.example.myapp.database.Book

class ShowbookAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    var data =  listOf<Book>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {

        holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)

        holder.textView.text = "Name : ${data[position].bookname}\n" +
                "Anthor : ${data[position].anthor}\n" +
                "Page : ${data[position].page}\n" +


        holder.textView.setTextColor(Color.BLACK)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater
            .inflate(R.layout.fragment_listlibrary, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}
class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)