/**
 * Canary Quake Catalog API
 * Catalog of Earthquakes in the Canary Islands in the last year
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package io.swagger.client.models

import com.beust.klaxon.JsonObject
import com.beust.klaxon.int
import com.beust.klaxon.string

/**
 *
 * @param OBJECTID
 * @param Nombre
 * @param Municipio
 * @param Telefono
 * @param Direccion
 * @param Foto
 */
data class AttributesParadaTaxi(
    val OBJECTID: Int?,
    val Nombre: String?,
    val Municipio: String?,
    val Telefono: Int?,
    val Direccion: String?,
    val Foto: String?
) {
  constructor(jsonObject: JsonObject?) : this(
      jsonObject?.int("OBJECTID"),
      jsonObject?.string("Nombre"),
      jsonObject?.string("Municipio"),
      jsonObject?.int("Telefono"),
      jsonObject?.string("Direccion"),
      jsonObject?.string("Foto")
  )
}
