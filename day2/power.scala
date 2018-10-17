import scala.math
object main extends App {

  def pow(arg1: Int, arg2: Int): BigDecimal = {
    return math.pow(arg1, arg2)
  }

  // custom pow
  def pow_2(arg1: Int, arg2: Int): BigDecimal = {
    var counter: Int = 1;
    var result: BigInt = 0;
    while (counter < arg2) {
      if (result == 0) { result = arg1 } else {
        result = result * arg1
        counter = counter + 1
      }
    }
    return BigDecimal(result)
  }
  val pow_result = pow(2, 3);
  println(s"Simple pow: $pow_result")

  val pow_result_2 = pow_2(2, 3);
  println(s"Custom pow: $pow_result_2")
}
