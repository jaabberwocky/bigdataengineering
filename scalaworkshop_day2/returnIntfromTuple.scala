object main extends App {

    def returnInt(arg1: Tuple2[Int, Int]): Any = {
        arg1._2.isInstanceOf[Int] match {
        case false => return None
        case true => return (arg1._2, arg1._1)
        }
    }

    println("Test (2,1)" + returnInt((2,1)))
}