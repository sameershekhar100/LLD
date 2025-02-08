package lld.ridesharingapp.v2


data class Passenger(
    override val name:String,
    override val email: String,
    override val location: Location
):User(name,email ,location )