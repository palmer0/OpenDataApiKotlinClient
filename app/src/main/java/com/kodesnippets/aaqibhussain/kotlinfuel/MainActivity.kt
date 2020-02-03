package com.kodesnippets.aaqibhussain.kotlinfuel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import io.swagger.client.models.LineasGuagua

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView : RecyclerView
    lateinit var recycletViewAdapter : RecyclerView.Adapter<FeaturesLineaAdapter.ViewHolder>
    //lateinit var recycletViewAdapter : RecyclerView.Adapter<FeaturesParadaAdapter.ViewHolder>
    lateinit var recyclerViewLayoutManager : RecyclerView.LayoutManager
    //var adapter: FeaturesParadaAdapter? = null
    var adapter: FeaturesLineaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        //getData()
        getData()

    }

    fun setupViews(){

        recyclerView = findViewById(R.id.recycler_view)
        recyclerViewLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = recyclerViewLayoutManager

    }

    fun getRequest(url: String, success: (String) -> Unit, failure: (FuelError) -> Unit) {

        Fuel.get(url).responseString() { request, response, result ->

            val (data, error) = result
            if (error != null) {
                Log.v("Error", error!!.toString())
                failure(error)
            } else {
                val onSuccess = data ?: return@responseString
                success(onSuccess)

            }

        }
    }


    /*
    fun getData(){

        val url = "https://services.arcgis.com/hkQNLKNeDVYBjvFE/arcgis/rest/services/Transportes/FeatureServer/0/query?where=1%3D1&outFields=OBJECTID,Nombre,Municipio,Telefono,Direccion,Foto&outSR=4326&f=json"
        getRequest(url,success = { response ->

            val parser = Parser()
            val stringBuilder = StringBuilder(response)

            val jsonObject =  parser.parse(stringBuilder) as JsonObject
            val response = ParadasTaxi(jsonObject)


            response.features?.let { features ->

                this.adapter = FeaturesParadaAdapter( features)
                recycletViewAdapter = adapter!!
                recyclerView.adapter = recycletViewAdapter
                recycletViewAdapter.notifyDataSetChanged()
                adapter?.onClick = { view ->

                }

            }


        },failure ={ error ->

        } )

    }
    */

    fun getData(){

        val url = "https://services.arcgis.com/hkQNLKNeDVYBjvFE/arcgis/rest/services/Transportes/FeatureServer/2/query?where=1%3D1&outFields=*&outSR=4326&f=json"
        getRequest(url,success = { response ->

            val parser = Parser()
            val stringBuilder = StringBuilder(response)

            val jsonObject =  parser.parse(stringBuilder) as JsonObject
            val response = LineasGuagua(jsonObject)


            response.features?.let { features ->

                this.adapter = FeaturesLineaAdapter( features)
                recycletViewAdapter = adapter!!
                recyclerView.adapter = recycletViewAdapter
                recycletViewAdapter.notifyDataSetChanged()
                adapter?.onClick = { view ->

                }

            }

        },failure ={ error ->

        } )


    }
}
