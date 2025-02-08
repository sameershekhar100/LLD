package lld.ridesharingapp.v2

import lld.ridesharingapp.v2.user.Driver
import lld.ridesharingapp.v2.user.Passenger

enum class RideStatus {
    SCHEDULED, ONGOING, COMPLETED
}

class Ride(
    private var passenger: Passenger,
    private var driver: Driver,
    private var distance: Double,
    private var fareStrategy: FareStrategy,
    private var rideStatus: RideStatus = RideStatus.SCHEDULED
) {
    private var _fare: Double = 0.0
    val fare: Double
        get() = _fare

    fun calcFare() {
        _fare = fareStrategy.calFare(distance, driver.vehicle)
    }


    fun updateStatus(status: RideStatus) {
        this.rideStatus = status
        notifyUsers(status)
    }

    private fun notifyUsers(status: RideStatus) {
        passenger.notify("Your ride status is $status")
        driver.notify("Ride status is $status")
    }
}