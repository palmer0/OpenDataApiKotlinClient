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
import com.beust.klaxon.double


/**
 *
 * @param x
 * @param y
 */
data class GeometryPoint(
    val x: kotlin.Double?,
    val y: kotlin.Double?
) {
  constructor(jsonObject: JsonObject?) : this(
      jsonObject?.double("x"),
      jsonObject?.double("y")
  )
}