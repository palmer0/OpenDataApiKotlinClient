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
import com.beust.klaxon.obj

/**
 *
 * @param attributes
 * @param geometry
 */
data class FeatureLineaGuagua(
        //val attributes: AttributesLineaGuagua
        val attributes: AttributesLineaGuagua,
        val geometry: GeometryPaths
) {

    /*
    constructor(jsonObject: JsonObject) : this(
            AttributesLineaGuagua(jsonObject.obj("attributes"))
    )
    */

    constructor(jsonObject: JsonObject) : this(
            AttributesLineaGuagua(jsonObject.obj("attributes")),
            GeometryPaths(jsonObject.obj("geometry"))
    )
}
