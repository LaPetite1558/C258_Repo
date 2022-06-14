package WeekTwo;

import java.util.Calendar;

public interface TimeNotif {
    static void timeNotif(String someDude) {
        // every n hours, notify client
        // int period = n; <- convert n hours to Time or something
        getDateTime();
    }

    static void getDateTime() {
        System.out.println(Calendar.getInstance().getTime());
    }
}
