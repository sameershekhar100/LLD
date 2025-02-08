package lld.ridesharingapp.v2

import kotlin.math.sqrt

data class Location(
    val lat: Double,
    val long: Double
) {
    private fun calculateDistance(location: Location): Double {
        val dx = this.lat - location.lat
        val dy = this.long - location.long
        return sqrt(dx * dx + dy * dy)
    }
}
