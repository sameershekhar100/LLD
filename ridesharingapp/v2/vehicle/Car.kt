package lld.ridesharingapp.v2.vehicle

data class Car constructor(
    override val numberPlate: String
): Vehicle(numberPlate) {
    override fun getFarePerKm(): Double {
        return 20.0
    }
}