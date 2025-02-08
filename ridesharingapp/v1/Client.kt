package lld.ridesharingapp.v1


fun main() {
    val l1 = Location(1.0, 2.0)
    val l2 = Location(3.0, 5.0)
    val l3 = Location(4.0, 6.0)

    val car = Vehicle("AB012CD", "Car")
    val bike = Vehicle("AB012CD", "Bike")

    val driver1 = Driver("Alice", car, l2)
    val driver2 = Driver("Bob", bike, l3)

    val passenger1 = Passenger("John", l1)
    val passenger2 = Passenger("Rahul", l3)

    val rideSharingAppService = RideSharingAppService()

    rideSharingAppService.addDriver(driver1)
    rideSharingAppService.addDriver(driver2)

    rideSharingAppService.addPassenger(passenger1)
    rideSharingAppService.addPassenger(passenger2)

    rideSharingAppService.bookRide(passenger1 , (10).toDouble())
    rideSharingAppService.bookRide(passenger2 , (20).toDouble())
}

