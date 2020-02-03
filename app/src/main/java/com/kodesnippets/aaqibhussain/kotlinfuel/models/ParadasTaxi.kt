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

import com.beust.klaxon.*


/**
 *
 * @param objectIdFieldName
 * @param globalIdFieldName
 * @param geometryType
 * @param spatialReference
 * @param fields
 * @param features
 */
data class ParadasTaxi(
        val objectIdFieldName: String?,
        val globalIdFieldName: String?,
        val geometryType: String?,
        val spatialReference: SpatialReference?,
        private val _fields: JsonArray<JsonObject>?,
        private val _features: JsonArray<JsonObject>?

) {
    constructor(jsonObject: JsonObject) : this(
            jsonObject.string("objectIdFieldName"),
            jsonObject.string("globalIdFieldName"),
            jsonObject.string("geometryType"),
            SpatialReference(jsonObject.obj("spatialReference")),
            jsonObject.array<JsonObject>("fields"),
            jsonObject.array<JsonObject>("features")
    )

    var fields : kotlin.Array<Fields?>? = transformFields(_fields)
    var features : kotlin.Array<FeatureParadaTaxi?>? = transformFeatures(_features)

    private fun transformFields(_fields: JsonArray<JsonObject>?): kotlin.Array<Fields?>? {
        if (_fields != null) {
            val fields = arrayOfNulls<Fields>(_fields.size)
            for (index in _fields.indices){
                fields[index] = Fields(_fields[index])
            }
            return fields
        }
        return null
    }

    private fun transformFeatures(_features: JsonArray<JsonObject>?): kotlin.Array<FeatureParadaTaxi?>? {
        if (_features != null) {
            val features = arrayOfNulls<FeatureParadaTaxi>(_features.size)
            for (index in _features.indices){
                features[index] = FeatureParadaTaxi(_features[index])
            }
            return features
        }
        return null
    }

}
