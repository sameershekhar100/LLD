package lld.ridesharingapp.v2

abstract class User(
    protected open val name: String,
    protected open val email: String,
    protected open val location: Location
)