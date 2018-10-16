object main extends App {

    def returnexpandedtuple(arg1: Tuple3[Any,Any,Any]): (Any, String, Any, String, Any, String) = {
        return (arg1._1, arg1._1.toString, arg1._2, arg1._2.toString, arg1._3, arg1._3.toString)
    }

    println(returnexpandedtuple((1,45,"123")))
}