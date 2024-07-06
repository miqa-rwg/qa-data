package data;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;


public final class DateUtils {

    private DateUtils() {
    }


    public static Date currentDate() {
        return new Date();
    }

    public static Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static LocalDate currentLocalDate() {
        return LocalDate.now();
    }

    public static LocalDateTime currentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static Calendar currentCalendar() {
        return dateToCalendar(currentDate());
    }

    public static String currentDateInFormat(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    public static Timestamp dateToTimestamp(Date date) {
        if (date != null) {
            long dateTime = date.getTime();
            return new Timestamp(dateTime);
        } else
            return null;
    }

    public static Date timestampToDate(Timestamp timestamp) {
        if (timestamp != null) {
            long timestampTime = timestamp.getTime();
            return new Date(timestampTime);
        } else
            return null;
    }

    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return zonedDateTime.toLocalDate();
    }

    public static Date localDateToDate(LocalDate localDate) {
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return localDateTimeToDate(localDateTime);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return zonedDateTime.toLocalDateTime();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        return Date.from(instant);
    }

    public static Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }

    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date stringToDate(String value, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Parsing error! Please check date value and date format.\n" + e);
        }
    }

    public static String dateToString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Calendar setCalendar(int year, int month, int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);

        return calendar;
    }

    public static Calendar calendarUnixTimeStart() {
       return setCalendar(1970, 0, 1, 0, 0, 0);
    }
}
