package lld.ridesharingapp.v2.user

import lld.ridesharingapp.v2.Location
import lld.ridesharingapp.v2.vehicle.Vehicle


data class Driver(
    override val name:String,
    override val email:String,
    val vehicle: Vehicle,
    override val location: Location
): User(name,email, location){

}