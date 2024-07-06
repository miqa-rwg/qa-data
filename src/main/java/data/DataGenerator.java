package data;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class DataGenerator {

    private DataGenerator() {
    }


    public static boolean getRandomBoolean() {
        return Math.random() >= 0.5;
    }


    public static int getRandomIntegerInRange(int min, int max) {
        return (int) (Math.round((max - min) * Math.random()) + min);
    }

    public static long getRandomLongInRange(long min, long max) {
        return Math.round((max - min) * Math.random()) + min;
    }

    public static double getRandomDoubleInRange(double min, double max, int... decimalPlaces) {
        assert decimalPlaces.length <= 1;
        if (decimalPlaces.length > 0 && decimalPlaces[0] > 0) {
            double random = (max - min) * Math.random() + min;
            double roundingParameter = Math.pow(10, decimalPlaces[0]);
            return Math.round(roundingParameter * random) / roundingParameter;
        }
        else {
            Random random = new Random();
            double randomValue = random.nextDouble();
            return min + (randomValue * (max - min));
        }
    }

    public static String getRandomString(int length,
                                         boolean useLatinCharacters,
                                         boolean useNumbers,
                                         boolean useSpecialCharacters,
                                         boolean useDiacriticCharacters,
                                         boolean useCyrillicCharacters) {
        String pool = "";
        if (useLatinCharacters)
            pool += "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
        if (useNumbers)
            pool += "0123456789";
        if (useSpecialCharacters)
            pool += "!@#$%^&*()_+-=[]{}|;':\"<>,.?/~`";
        if (useDiacriticCharacters)
            pool += "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÑÒÓÔÕÖØŒÙÚÛÜÝÞßàáâãäåæçèéêëìíîïñòóôõöøœùúûüýþÿ";
        if (useCyrillicCharacters)
            pool += "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" + "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        StringBuilder stringBuffer = new StringBuilder(length);
        for (int index = 0; index < length; index++) {
            int charIndex = (int) (pool.length() * Math.random());
            char character = pool.charAt(charIndex);
            stringBuffer.append(character);
        }
        return stringBuffer.toString();
    }

    public static String getRandomString(String label) {
        boolean useLatinCharacters = label.toLowerCase().contains("latin");
        boolean useNumbers = label.toLowerCase().contains("numbers");
        boolean useSpecialCharacters = label.toLowerCase().contains("special");
        boolean useDiacriticCharacters = label.toLowerCase().contains("diacritic");
        boolean useCyrillicCharacters = label.toLowerCase().contains("cyrillic");

        String sizeLabel = label.replaceAll("[A-Za-z:=,+\\s]", "");
        int size = sizeLabel.isEmpty() ? 5 : Integer.parseInt(sizeLabel);

        return getRandomString(size, useLatinCharacters, useNumbers, useSpecialCharacters, useDiacriticCharacters, useCyrillicCharacters);
    }

    public static Date getDate(String dateLabel) {
        if (dateLabel.contains("future"))
            return getRandomFutureDate();
        if (dateLabel.contains("past"))
            return getRandomPastDate();
        if (dateLabel.contains("current"))
            return DateUtils.currentDate();
        return getRandomDate();
    }

    public static Date getRandomDate() {
        int random = getRandomIntegerInRange(0, 299);
        if (random < 100)
            return getRandomPastDate();
        if (random < 200)
            return DateUtils.currentDate();
        return getRandomFutureDate();
    }

    public static Date getRandomPastDate() {
        long startTimestamp = DateUtils.calendarUnixTimeStart().getTimeInMillis();

        Calendar yesterday = DateUtils.currentCalendar();
        yesterday.add(Calendar.DATE, -1);
        long endTimestamp = yesterday.getTimeInMillis();

        long randomTimestamp = getRandomLongInRange(startTimestamp, endTimestamp);
        return new Date(randomTimestamp);
    }

    public static Date getRandomFutureDate() {
        long unixTimeStartTimestamp = DateUtils.calendarUnixTimeStart().getTimeInMillis();

        Calendar nextDay = DateUtils.currentCalendar();
        nextDay.add(Calendar.DATE, 1);
        long startTimestamp = nextDay.getTimeInMillis();

        long endTimestamp = 2 * startTimestamp - unixTimeStartTimestamp;
        long randomTimestamp = getRandomLongInRange(startTimestamp, endTimestamp);
        return new Date(randomTimestamp);
    }

    public static Object getValue(String valueLabel) {
        if (valueLabel.contains("null"))             return null;
        if (valueLabel.contains("empty"))            return "";
        if (valueLabel.contains("space"))            return " ";
        if (valueLabel.contains("boolean"))          return getRandomBoolean();
        if (valueLabel.contains("double"))           return getRandomDoubleInRange(0., 1000., 2);
        if (valueLabel.contains("integer"))          return getRandomIntegerInRange(0, 1000);
        if (valueLabel.contains("string"))           return getRandomString(valueLabel);
        if (valueLabel.contains("date"))             return getDate(valueLabel);
        if (valueLabel.contains("use: "))            return valueLabel.replace("use: ", "");
        throw new RuntimeException("Check please if you are using a correct label to get the data generated");
    }
}
