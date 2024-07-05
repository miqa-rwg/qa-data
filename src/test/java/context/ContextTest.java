package context;

import data.DataGenerator;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


class ContextTest {

    private static final Logger logger = Logger.getLogger(ContextTest.class.getName());

    private final int intValue = DataGenerator.getRandomIntegerInRange(-100, 100);
    private final double doubleValue = DataGenerator.getRandomDoubleInRange(-100, 100, 2);
    private final boolean booleanValue = DataGenerator.getRandomBoolean();
    private final String stringValue = DataGenerator.getRandomString("random string of size 10: Latin characters, numbers, special characters");


    @Test
    public void validateContextWhenUsingInteger() {
        String key = "integer";
        Context.put(key, intValue);
        logger.info("Initial value stored in context: key = " + key + ", intValue = " + intValue);

        Integer value = Context.get(key, Integer.class);
        assertNotNull(value);
        assertEquals(intValue, value);
        logger.info("Initial value got from the context: key = " + key + ", value = " + value);

        Integer updatedValue = value + 1;
        Context.update(key, updatedValue);
        assertEquals(updatedValue, Context.get(key, Integer.class));
        logger.info("Value is updated in the context: key = " + key + ", value = " + updatedValue);

        Context.remove(key);
        assertNull(Context.get(key, Integer.class));
        logger.info("Result after deleting the value from the context - should be null\nactual result:\nkey = " + key +  ", value = " + Context.get(key, Integer.class));
    }


    @Test
    public void validateContextWhenUsingDouble() {
        String key = "double";
        Context.put(key, doubleValue);
        logger.info("Initial value stored in context: key = " + key + ", doubleValue = " + doubleValue);

        Double value = Context.get(key, Double.class);
        assertNotNull(value);
        assertEquals(doubleValue, value);
        logger.info("Initial value got from the context: key = " + key + ", value = " + value);

        Double updatedValue = value + 1;
        Context.update(key, updatedValue);
        assertEquals(updatedValue, Context.get(key, Double.class));
        logger.info("Value is updated in the context: key = " + key + ", value = " + updatedValue);

        Context.remove(key);
        assertNull(Context.get(key, Double.class));
        logger.info("Result after deleting the value from the context - should be null\nactual result:\nkey = " + key +  ", value = " + Context.get(key, Double.class));
    }

    @Test
    public void validateContextWhenUsingBoolean() {
        String key = "boolean";
        Context.put(key, booleanValue);
        logger.info("Initial value stored in context: key = " + key + ", doubleValue = " + booleanValue);

        Boolean value = Context.get(key, Boolean.class);
        assertNotNull(value);
        assertEquals(booleanValue, value);
        logger.info("Initial value got from the context: key = " + key + ", value = " + value);

        Boolean updatedValue = !value;
        Context.update(key, updatedValue);
        assertEquals(updatedValue, Context.get(key, Boolean.class));
        logger.info("Value is updated in the context: key = " + key + ", value = " + updatedValue);

        Context.remove(key);
        assertNull(Context.get(key, Boolean.class));
        logger.info("Result after deleting the value from the context - should be null\nactual result:\nkey = " + key +  ", value = " + Context.get(key, Boolean.class));
    }

    @Test
    public void validateContextWhenUsingString() {
        String key = "string";
        Context.put(key, stringValue);
        logger.info("Initial value stored in context: key = " + key + ", doubleValue = " + stringValue);

        String value = Context.get(key, String.class);
        assertNotNull(value);
        assertEquals(stringValue, value);
        logger.info("Initial value got from the context: key = " + key + ", value = " + value);

        String updatedValue = value + 1;
        Context.update(key, updatedValue);
        assertEquals(updatedValue, Context.get(key, String.class));
        logger.info("Value is updated in the context: key = " + key + ", value = " + updatedValue);

        Context.remove(key);
        assertNull(Context.get(key, String.class));
        logger.info("Result after deleting the value from the context - should be null\nactual result:\nkey = " + key +  ", value = " + Context.get(key, String.class));
    }
}
