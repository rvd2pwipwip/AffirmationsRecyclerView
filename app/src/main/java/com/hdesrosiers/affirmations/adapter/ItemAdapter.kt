package com.hdesrosiers.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hdesrosiers.affirmations.R
import com.hdesrosiers.affirmations.model.Affirmation

/**
To implement the adapter:

* Create a new class for the adapter, for example, ItemAdapter.
* Create a custom ViewHolder class that represents a single list item view. Extend from RecyclerView.ViewHolder class.
* Modify the ItemAdapter class to extend from the RecyclerView.Adapter class with the custom ViewHolder class.
* Implement these methods within the adapter: getItemsCount(), onCreateViewHolder(), and onBindViewHolder().
 */


/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */

class ItemAdapter(
    private  val dataset: List<Affirmation>, //the data
//    The ItemAdapter needs information on how to resolve the string resources.
//    This, and other information about the app, is stored in a Context object instance that you can pass into an ItemAdapter instance.
    private val context: Context
//    5. Add the code to extend your ItemAdapter from the abstract class RecyclerView.Adapter.
//       Specify ItemAdapter.ItemViewHolder as the view holder type in angle brackets.
    ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() { // the view holder

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.

//    1. Create an ItemViewHolder class.
//    2. Add a private val view of type View as a parameter to the ItemViewHolder class constructor.
//    3. Make ItemViewHolder a subclass of RecyclerView.ViewHolder and pass the view parameter into the superclass constructor.
    inner class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
//    4. Inside ItemViewHolder, define a val property textView that is of type TextView.
//       Assign it the view with the ID item_title that you defined in list_item.xml.
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    //only called a few times (enough to fill the container plus a few extras above and below)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//      1. Get the item at the given position in the dataset
        val item = dataset[position] // Affirmation instance
//      2. With an Affirmation object instance, you can find the corresponding string resource ID by calling item.stringResourceId.
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}