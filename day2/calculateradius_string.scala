import scala.math

object Main extends App {
    
    def calculate_radius_string(radius: String): Double = {
        if (radius == "") { return 0 }
        val radius_double = radius.toDouble
        return radius_double * radius_double * math.Pi
    }

    println("empty string:" + calculate_radius_string(""))
    println("5: " + calculate_radius_string("5"))
    
}


