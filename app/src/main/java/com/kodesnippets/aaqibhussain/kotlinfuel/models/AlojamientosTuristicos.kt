/**
 * La Palma Open Data
 * Portal de datos abiertos de la Isla de La Palma
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package io.swagger.client.models

/**
 *
 * @param objectIdFieldName
 * @param globalIdFieldName
 * @param geometryType
 * @param spatialReference
 * @param fields
 * @param features
 */
data class AlojamientosTuristicos(
    val objectIdFieldName: String? = null,
    val globalIdFieldName: String? = null,
    val geometryType: String? = null,
    val spatialReference: SpatialReference? = null,
    val fields: Array<Fields>? = null,
    val features: Array<FeatureAlojamientosTuristicos>? = null
)

