object main extends App {

    def print_value(number: Int) {
        if (number > 50) {
            // do nothing
        } else {
            println(number)
            return print_value(number+5)
        }
    }
    print_value(5)
}
