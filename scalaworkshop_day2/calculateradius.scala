import scala.math

object Main extends App {

    def calculate_radius(radius: Double) : Double = {
        return radius * radius * math.Pi;
    }

    println(calculate_radius(5));
}