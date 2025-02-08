package lld.ridesharingapp.v2.vehicle

abstract class Vehicle(
    protected open val numberPlate: String,
) {
    abstract fun getFarePerKm(): Double
}
