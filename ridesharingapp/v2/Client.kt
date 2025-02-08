package lld.ridesharingapp.v2

import lld.ridesharingapp.v2.vehicle.Bike
import lld.ridesharingapp.v2.vehicle.Car


fun main() {
    val l1 = Location(1.0, 2.0)
    val l2 = Location(3.0, 5.0)
    val l3 = Location(4.0, 6.0)

    val car = Car("AB012CD")
    val bike = Bike("AB012CD")

    val driver1 = Driver("Alice", "aa", car, l2)
    val driver2 = Driver("Bob", "bb", bike, l3)

    val passenger1 = Passenger("John", "cc", l1)
//    val passenger2 = Passenger("Rahul", "dd", l2)

    val rideSharingAppService = RideMatchingSystem()

    rideSharingAppService.addDriver(driver1)
    rideSharingAppService.addDriver(driver2)


    rideSharingAppService.bookRide(passenger1, (10).toDouble(), StandardFareStrategy())
//    rideSharingAppService.bookRide(passenger2, (20).toDouble(),SharedFareStrategy())
}

