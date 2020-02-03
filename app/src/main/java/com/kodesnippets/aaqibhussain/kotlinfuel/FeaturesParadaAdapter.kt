package com.kodesnippets.aaqibhussain.kotlinfuel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.swagger.client.models.FeatureParadaTaxi


/**
 * Created by aaqibhussain on 24/9/17.
 */
class FeaturesParadaAdapter(
        dataSet: Array<FeatureParadaTaxi?>
) : RecyclerView.Adapter<FeaturesParadaAdapter.ViewHolder>(){

    val dataSet : Array<FeatureParadaTaxi?> = dataSet
    final var onClick : (View)-> Unit = {}

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val titleTextView = view.findViewById<TextView>(R.id.title_text_view) as TextView
        val bodyTextView = view.findViewById<TextView>(R.id.body_text_view) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.recycler_view_row, parent,false)

        view.setOnClickListener(View.OnClickListener { view ->
            this.onClick(view)
        })
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.let { holder ->
            this.dataSet[position]?.let { data ->
                val attributes = data.attributes
                holder.titleTextView.text = attributes.Nombre
                holder.bodyTextView.text = attributes.Direccion
            }
        }

    }


    override fun getItemCount(): Int {

        return  this.dataSet.size
    }



}