package com.kodesnippets.aaqibhussain.kotlinfuel

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.swagger.client.models.FeatureLineaGuagua


/**
 * Created by aaqibhussain on 24/9/17.
 */
class FeaturesLineaAdapter(
        dataSet: Array<FeatureLineaGuagua?>
) : RecyclerView.Adapter<FeaturesLineaAdapter.ViewHolder>(){

    val dataSet : Array<FeatureLineaGuagua?> = dataSet
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
                data.geometry.paths?.let { paths ->
                    for (path in paths) {
                        if (path != null) {
                            for (points in path) {
                                if (points != null) {
                                    for (point in points) {
                                        Log.d("point=", point.toString())
                                    }
                                }
                            }
                        }
                    }
                }

                val attributes = data.attributes
                holder.titleTextView.text = attributes.Linea.toString()
                holder.bodyTextView.text = attributes.Recorrido
            }
        }

    }


    override fun getItemCount(): Int {

        return  this.dataSet.size
    }



}