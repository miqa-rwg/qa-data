package rest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RestParameterTest {

    @Test
    public void validateEmptyConstructor() {
        RestParameter restParameter = new RestParameter();
        assertNull(restParameter.getKey());
        assertNull(restParameter.getValue());
    }

    @Test
    public void validateConstructorWithParams() {
        RestParameter restParameter = new RestParameter("key", "value");
        assertEquals("key", restParameter.getKey());
        assertEquals("value", restParameter.getValue());
    }

    @Test
    public void validateSetters() {
        RestParameter restParameter = new RestParameter();
        restParameter.setKey("key");
        restParameter.setValue("value");
        assertEquals("key", restParameter.getKey());
        assertEquals("value", restParameter.getValue());
    }

    @Test
    public void validateToString() {
        RestParameter restParameter = new RestParameter("key", "value");
        String result = restParameter.toString();
        assertTrue(result.contains("RestParameter { "));
        assertTrue(result.contains(" }"));
        assertTrue(result.contains("key=key"));
        assertTrue(result.contains("value=value"));
        System.out.println(result);
    }
}
