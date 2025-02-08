package lld.ridesharingapp.v2

abstract class User(
     open val name: String,
     open val email: String,
     open val location: Location
){
    fun notify(msg:String){
        println(msg)
    }
}