package com.graymandev.sapp.view.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.graymandev.sapp.R
import com.graymandev.sapp.model.database.entities.TimeRecord

class FeedListAdapter(private val records: ArrayList<TimeRecord>) :
    RecyclerView.Adapter<FeedListAdapter.ViewHolder>() {

    fun updateRecordsList(newList: List<TimeRecord>){
        records.clear()
        records.addAll(newList)
        notifyDataSetChanged()
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = records[position].dateTime
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = records.size

}