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


  lateinit var recyclerView: RecyclerView
  lateinit var recyclerAdapter: RecyclerView.Adapter<FeaturesLineaAdapter.ViewHolder>
  //lateinit var recyclerAdapter : RecyclerView.Adapter<FeaturesParadaAdapter.ViewHolder>
  //lateinit var recyclerAdapter : RecyclerView.Adapter<FeaturesAlojamientosAdapter.ViewHolder>
  lateinit var recyclerLayoutManager: RecyclerView.LayoutManager
  //var dataAdapter: FeaturesParadaAdapter? = null
  //var dataAdapter: FeaturesAlojamientosAdapter? = null
  var dataAdapter: FeaturesLineaAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setupViews()
    //getData()
    getData()

  }

  private fun setupViews() {

    recyclerView = findViewById(R.id.recycler_view)
    recyclerLayoutManager = LinearLayoutManager(applicationContext)
    recyclerView.layoutManager = recyclerLayoutManager

  }

  private fun getRequest(
      url: String, success: (String) -> Unit, failure: (FuelError) -> Unit
  ) {

    Fuel.get(url).responseString { request, response, result ->

      val (data, error) = result

      if (error != null) {
        Log.v("Error", error.toString())
        failure(error)
      } else {
        val onSuccess = data ?: return@responseString
        success(onSuccess)

      }

    }
  }



  fun getData() {

    //val url = "https://services.arcgis.com/hkQNLKNeDVYBjvFE/arcgis/rest/services/Transportes/FeatureServer/0/query?where=1%3D1&outFields=OBJECTID,Nombre,Municipio,Telefono,Direccion,Foto&outSR=4326&f=json"
    val url = "https://services.arcgis.com/hkQNLKNeDVYBjvFE/arcgis/rest/services/Transportes/FeatureServer/2/query?where=1%3D1&outFields=*&outSR=4326&f=json"

    getRequest(url, success = { response ->

      val parser = Parser()
      val stringBuilder = StringBuilder(response)

      val jsonObject = parser.parse(stringBuilder) as JsonObject
      val response = LineasGuagua(jsonObject)
      //val response = ParadasGuagua(jsonObject)
      //val response = AlojamientosTuristicos(jsonObject)


      response.features?.let { features ->

        this.dataAdapter = FeaturesLineaAdapter(features)
        //this.dataAdapter = FeaturesParadaAdapter(features)
        recyclerAdapter = dataAdapter!!
        recyclerView.adapter = recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()
        dataAdapter?.onClick = { view ->

        }

      }

    }, failure = { error ->

    })


  }
}
