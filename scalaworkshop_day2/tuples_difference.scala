import scala.math
object main extends App {

    def difference_points(point1: Tuple2[Int, Int], point2: Tuple2[Int,Int]): Double = {
        val dx:Int = point1._1 - point2._1
        val dy:Int = point1._2 - point2._2
        val distance = math.sqrt(math.pow(dx,2) + math.pow(dy,2))
        return distance
    }

    println("Diff (1,2) and (3,2): " + difference_points((1,2),(3,2)))
    println("Diff (15,20) and (35,5): " + difference_points((15,20),(35,5)))
}