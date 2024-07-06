package data;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import static data.DateUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class DateUtilsTest {

    private static final Logger logger = Logger.getLogger(DateUtilsTest.class.getName());

    private final String format = "yyyy-MM-dd'T'HH:mm:ss";


    @Test
    public void validateCurrentDate() {
        long initTimeInSeconds = new Date().getTime() / 1000;
        Date result = currentDate();
        long resultTimeInSeconds = result.getTime() / 1000;
        assertNotNull(result);
        assertEquals(initTimeInSeconds, resultTimeInSeconds);
        logger.info("result = " + result);
    }

    @Test
    public void validateCurrentTimestamp() {
        long initTimeInSeconds = new Timestamp(System.currentTimeMillis()).getTime() / 1000;
        Timestamp result = currentTimestamp();
        long resultTimeInSeconds = result.getTime() / 1000;
        assertNotNull(result);
        assertEquals(initTimeInSeconds, resultTimeInSeconds);
        logger.info("result = " + result);
    }

    @Test
    public void validateCurrentLocalDate() {
        long initDate = LocalDate.now().toEpochDay();
        LocalDate result = currentLocalDate();
        long resultDate = result.toEpochDay();
        assertNotNull(result);
        assertEquals(initDate, resultDate);
        logger.info("result = " + result);
    }

    @Test
    public void validateCurrentLocalDateTime() {
        long initTimeInSeconds = LocalDateTime.now().toLocalTime().getSecond();
        LocalDateTime result = currentLocalDateTime();
        long resultTimeInSeconds = result.toLocalTime().getSecond();
        assertNotNull(result);
        assertEquals(initTimeInSeconds, resultTimeInSeconds);
        logger.info("result = " + result);
    }

    @Test
    public void validateCurrentCalendar() {
        long initTimeInSeconds = dateToCalendar(new Date()).getTimeInMillis() / 1000;
        Calendar result = currentCalendar();
        long resultTimeInSeconds = result.getTimeInMillis() / 1000;
        assertNotNull(result);
        assertEquals(initTimeInSeconds, resultTimeInSeconds);
        logger.info("result = " + result);
    }

    @Test
    public void validateCurrentDateInFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String initDateString = simpleDateFormat.format(new Date());
        String result = currentDateInFormat(format);
        assertNotNull(result);
        assertEquals(initDateString, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateDateToTimestamp() {
        long init = dateToTimestamp(new Date()).getTime() / 1000;
        long result = dateToTimestamp(new Date()).getTime() / 1000;
        assertEquals(init, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateTimestampToDate() {
        long init = timestampToDate(new Timestamp(new Date().getTime())).getTime() / 1000;
        long result = timestampToDate(new Timestamp(new Date().getTime())).getTime() / 1000;
        assertEquals(init, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateDateToLocalDate() {
        long init = dateToLocalDate(new Date()).toEpochDay();
        long result = dateToLocalDate(new Date()).toEpochDay();
        assertEquals(init, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateLocalDateToDate() {
        long init = localDateToDate(LocalDate.now()).getTime() / 1000;
        long result = localDateToDate(LocalDate.now()).getTime() / 1000;
        assertEquals(init, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateDateToLocalDateTime() {
        long init = dateToLocalDateTime(new Date()).getSecond();
        long result = dateToLocalDateTime(new Date()).getSecond();
        assertEquals(init, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateLocalDateTimeToDate() {
        long init = localDateTimeToDate(LocalDateTime.now()).getTime() / 1000;
        long result = localDateTimeToDate(LocalDateTime.now()).getTime() / 1000;
        assertEquals(init, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateCalendarToDate() {
        Calendar calendar = setCalendar(2000, 0, 1, 0, 0, 0);
        Date date = calendarToDate(calendar);
        long init = calendar.getTimeInMillis() / 1000;
        long result = date.getTime() / 1000;
        assertEquals(init, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateDateToCalendar() {
        Date date = new Date();
        Calendar calendar = dateToCalendar(new Date());
        long init = calendar.getTimeInMillis() / 1000;
        long result = date.getTime() / 1000;
        assertEquals(init, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateStringToDate() {
        String value = currentDateInFormat(format);
        Date date = stringToDate(value, format);
        String dateValue = dateToString(date, format);
        assertEquals(value, dateValue);
        logger.info("result = " + date);
    }

    @Test
    public void validateDateToString() {
        String result = dateToString(new Date(), format);
        String value = currentDateInFormat(format);
        assertEquals(value, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateSetCalendar() {
        Calendar initCalendar = currentCalendar();
        initCalendar.get(Calendar.YEAR);
        Calendar calendar = setCalendar(
                initCalendar.get(Calendar.YEAR),
                initCalendar.get(Calendar.MONTH),
                initCalendar.get(Calendar.DATE),
                initCalendar.get(Calendar.HOUR),
                initCalendar.get(Calendar.MINUTE),
                initCalendar.get(Calendar.SECOND)
        );
        long init = initCalendar.getTimeInMillis() / 1000;
        long seconds = calendar.getTimeInMillis() / 1000;
        assertEquals(init, seconds);
        logger.info("result = " + calendar);
    }

    @Test
    public void validateCalendarUnixTimeStart() {
        Calendar calendar = calendarUnixTimeStart();
        assertEquals(1970, calendar.get(Calendar.YEAR));
        assertEquals(0, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DATE));
        assertEquals(0, calendar.get(Calendar.HOUR));
        assertEquals(0, calendar.get(Calendar.MINUTE));
        assertEquals(0, calendar.get(Calendar.SECOND));
        logger.info("result = " + calendar);
    }
}
