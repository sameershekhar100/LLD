package lld.ridesharingapp.v1

import kotlin.math.sqrt

class RideSharingAppService {
    //Matching Service
    val drivers: List<Driver> = ArrayList()
    val passengers: List<Passenger> = ArrayList()

    fun addDriver(driver: Driver) {
        drivers.addLast(driver)
    }

    fun addPassenger(passenger: Passenger) {
        passengers.addLast(passenger)
    }

    fun bookRide(passenger: Passenger, distance: Double) {
        if (drivers.isEmpty()) {
            print("No drivers available for $passenger.name")
            return
        }

        lateinit var assignedDriver: Driver
        var minDis = Double.MAX_VALUE
        for (driver in drivers) {
            val distance: Double = calculateDistance(passenger, driver)
            if (distance < minDis) {
                assignedDriver = driver
                minDis = distance
            }
        }

        val fare = calcFare(assignedDriver.vehicle, distance);
        println("Ride booked for customer ${passenger.name} with driver ${assignedDriver.name} with a fare of $fare")
        println("Driver is on the way ${assignedDriver.name}")
    }

    private fun calcFare(vehicle: Vehicle, distance: Double): Double =
        when (vehicle.type) {
            "Car" -> distance * 28
            "Bike" -> distance * 10
            else -> distance * 8
        }

    private fun calculateDistance(passenger: Passenger, driver: Driver): Double {
        val dx = passenger.location.lat - driver.location.lat
        val dy = passenger.location.long - driver.location.long
        return sqrt(dx * dx + dy * dy)
    }
}