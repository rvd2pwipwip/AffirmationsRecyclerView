package com.hdesrosiers.affirmations

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hdesrosiers.affirmations.adapter.ItemAdapter
import com.hdesrosiers.affirmations.data.Datasource

/*
To finish, you need to use your Datasource and ItemAdapter classes
to create and display items in the RecyclerView.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      1. Create an instance of Datasource, and call the loadAffirmations() method on it.
//         Store the returned list of affirmations in a val named myDataset.
        val myDataset = Datasource().loadAffirmations()
//      2. Create a variable called recyclerView and use findViewById()
//         to find a reference to the RecyclerView within the layout.
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//      3. To tell the recyclerView to use the ItemAdapter class you created, create a new ItemAdapter instance.
//         ItemAdapter expects two parameters: the affirmations in myDataset and the context (this) of this activity.
//      4. Assign the ItemAdapter object to the adapter property of the recyclerView.
//        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = ItemAdapter(myDataset, this)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

    }
}