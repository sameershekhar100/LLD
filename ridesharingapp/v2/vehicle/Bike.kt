package lld.ridesharingapp.v2.vehicle

data class Bike(
    override val numberPlate: String
): Vehicle(numberPlate) {
    override fun getFarePerKm(): Double {
        return 10.0
    }
}