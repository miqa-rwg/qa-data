package rest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RestMethodTest {

    private static final Logger logger = Logger.getLogger(RestMethodTest.class.getName());

    private final List<String> labels = Arrays.stream(RestMethod.values()).toList()
            .stream().map(i -> i.toString().toLowerCase()).toList();


    @Test
    public void validateGetValueByLabel() {
        for(String label : labels) {
            RestMethod method = RestMethod.getValueByString(label);
            assertTrue(method.toString().equalsIgnoreCase(label));
            logger.info("label = " + label + " related to RestMethod = " + method);
        }
    }

    @Test
    public void validateGetValuesExcept() {
        for(RestMethod method : RestMethod.values()) {
            List<RestMethod> methods = RestMethod.getValuesExcept(method);
            for(RestMethod filteredMethod : methods)
                assertNotEquals(filteredMethod, method);
            logger.info("method = " + method + " is excepted from the list = " + methods);
        }
    }
}
