package data;


import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.logging.Logger;

import static data.DataGenerator.*;
import static org.junit.jupiter.api.Assertions.*;


class DataGeneratorTest {

    private static final Logger logger = Logger.getLogger(DataGeneratorTest.class.getName());


    @Test
    public void validateRandomBoolean() {
        Boolean result = getRandomBoolean();
        assertNotNull(result);
        logger.info("result = " + result);
    }

    @Test
    public void validateRandomInteger() {
        int result = getRandomIntegerInRange(100, 999);
        assertTrue(result >= 100);
        assertTrue(result <= 999);
        logger.info("result = " + result);
    }

    @Test
    public void validateRandomDoubleWithSpecifiedDecimalPlaces() {
        double result = getRandomDoubleInRange(100., 999., 3);
        assertTrue(result >= 100);
        assertTrue(result <= 999);
        logger.info("result = " + result);
    }

    @Test
    public void validateRandomDoubleWithNoSpecifiedDecimalPlaces() {
        double result = getRandomDoubleInRange(100., 999.);
        assertTrue(result >= 100);
        assertTrue(result <= 999);
        logger.info("result = " + result);
    }

    @Test
    public void validateRandomStringWithLatinCharactersOnly() {
        String result = getRandomString("latin");
        assertFalse(result.isEmpty());
        assertEquals(5, result.length());
        String result1 = result.replaceAll("[A-Za-z]", "");
        assertTrue(result1.isEmpty());
        logger.info("result = " + result);
    }

    @Test
    public void validateRandomStringWithNumbersOnly() {
        String result = getRandomString("numbers");
        assertFalse(result.isEmpty());
        assertEquals(5, result.length());
        String result1 = result.replaceAll("\\d", "");
        assertTrue(result1.isEmpty());
        logger.info("result = " + result);
    }

    @Test
    public void validateRandomStringOfSize() {
        int size = DataGenerator.getRandomIntegerInRange(1, 100);
        String result = getRandomString(size + " latin characters");
        assertFalse(result.isEmpty());
        assertEquals(size, result.length());
        logger.info("result = " + result + ", size = " + size);
    }

    @Test
    public void validateRandomStringOfDefaultSize() {
        String result = getRandomString("latin characters");
        assertFalse(result.isEmpty());
        assertEquals(5, result.length());
        logger.info("result = " + result + ", size = " + 5);
    }

    @Test
    public void validateRandomPastDate() {
        Date result = getRandomPastDate();
        assertNotNull(result);
        assertTrue(new Date().after(result));
        logger.info("result = " + result);
    }

    @Test
    public void validateRandomFutureDate() {
        Date result = getRandomFutureDate();
        assertNotNull(result);
        assertTrue(new Date().before(result));
        logger.info("result = " + result);
    }

    @Test
    public void validateRandomCurrentDate() {
        long initTimeInSeconds = new Date().getTime() / 1000;
        Date result = getDate("current");
        long resultTimeInSeconds = result.getTime() / 1000;
        assertNotNull(result);
        assertEquals(initTimeInSeconds, resultTimeInSeconds);
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetNull() {
        Object result = getValue("null");
        assertNull(result);
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetEmptyString() {
        Object result = getValue("empty");
        String result1 = String.valueOf(result);
        assertTrue(result1.isEmpty());
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetSpace() {
        Object result = getValue("space");
        String result1 = String.valueOf(result);
        assertEquals(1, result1.length());
        assertEquals(" ", result1);
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetBoolean() {
        Object result = getValue("boolean");
        assertInstanceOf(Boolean.class, result);
        assertNotNull(result);
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetDouble() {
        Object result = getValue("double");
        assertInstanceOf(Double.class, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetInteger() {
        Object result = getValue("integer");
        assertInstanceOf(Integer.class, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetString() {
        Object result = getValue("string of latin chars");
        assertInstanceOf(String.class, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetDate() {
        Object result = getValue("date");
        assertInstanceOf(Date.class, result);
        logger.info("result = " + result);
    }

    @Test
    public void validateCommonMethodToGetSpecifiedValue() {
        String initialValue = "SpaceX";
        Object result = getValue("use: " + initialValue);
        assertInstanceOf(String.class, result);
        assertEquals(initialValue, result);
        logger.info("result = " + result);
    }
}
