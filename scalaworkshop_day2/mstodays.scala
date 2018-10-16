object main extends App {

    def prettyprint(ms: Int): String = {
        var ms_left = 0;

        // get number of days
        val days = ms / 86400000;
        ms_left = ms % 86400000;

        // get number of hours
        val hours = ms_left / 3600000;
        ms_left = ms_left % 3600000;

        // get number of minutes
        val minutes = ms_left / 60000;
        ms_left = ms_left % 60000;

        // get number of seconds
        val seconds = ms_left.toFloat / 1000.toFloat;
        
        return s"Days: $days, Hours: $hours, Minutes: $minutes, Seconds: $seconds"
    }

    println(prettyprint(123123000));
}