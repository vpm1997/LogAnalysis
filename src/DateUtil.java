import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    public static String datetimeformat = "%d:%d-%d:%02d";

    public static String getDateTimeQuater(String time){
        Date date = new Date(Long.valueOf(time));
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.setTimeZone(TimeZone.getTimeZone("IST"));
        int minute = calender.get(Calendar.MINUTE);
        int quater = (minute/15)%4;
        int nextquater = quater + 1;
        int hourofday = calender.get(Calendar.HOUR_OF_DAY);
        return String.format(datetimeformat, hourofday,quater*15,hourofday + nextquater/4,(nextquater)%4*15);
    }
    
}
