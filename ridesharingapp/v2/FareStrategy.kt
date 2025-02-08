package lld.ridesharingapp.v2

import lld.ridesharingapp.v2.vehicle.Vehicle

interface FareStrategy {
    fun calFare(distance: Double, vehicle: Vehicle): Double
}

class StandardFareStrategy : FareStrategy {
    override fun calFare(distance: Double, vehicle: Vehicle) =
        vehicle.getFarePerKm() * distance
}

class SharedFareStrategy : FareStrategy {
    override fun calFare(distance: Double, vehicle: Vehicle) =
        vehicle.getFarePerKm() * distance * 0.50
}

class LuxuryFareStrategy : FareStrategy {
    override fun calFare(distance: Double, vehicle: Vehicle) =
        vehicle.getFarePerKm() * distance * 1.8
}
