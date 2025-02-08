package lld.ridesharingapp.v2

import lld.ridesharingapp.v2.user.Driver
import lld.ridesharingapp.v2.user.Passenger


class RideMatchingSystem {

    private val drivers: ArrayList<Driver> = arrayListOf()

    fun addDriver(driver: Driver) {
        drivers.addLast(driver)
    }

    fun bookRide(passenger: Passenger, distance: Double, fareStrategy: FareStrategy) {
        if (drivers.isEmpty()) {
            //notify
            passenger.notify("No available drivers")
            return
        }
        val nearestAvailableDriver = findNearestDriver(passenger.location)

        drivers.remove(nearestAvailableDriver)

        val ride = Ride(
            passenger,
            nearestAvailableDriver,
            distance,
            fareStrategy
        )

        ride.calcFare()
        passenger.notify("Ride scheduled successfully with fare ${ride.fare}")
        nearestAvailableDriver.notify("You have a new ride request  fare ${ride.fare}")

        ride.updateStatus(RideStatus.ONGOING)
        ride.updateStatus(RideStatus.COMPLETED)
        drivers.add(nearestAvailableDriver)
    }

    private fun findNearestDriver(passengerLocation: Location): Driver {
        lateinit var assignedDriver: Driver
        var minDis = Double.MAX_VALUE
        for (driver in drivers) {
            val distance: Double = driver.location.calculateDistance(passengerLocation)
            if (distance < minDis) {
                assignedDriver = driver
                minDis = distance
            }
        }
        return assignedDriver
    }
}