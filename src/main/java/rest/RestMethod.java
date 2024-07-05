package rest;

import java.util.LinkedList;
import java.util.List;


public enum RestMethod {
    DELETE,
    GET,
    PATCH,
    POST,
    PUT;


    public static RestMethod getValueByString(String label) {
        for (RestMethod item : RestMethod.values()) {
            if (item.toString().equalsIgnoreCase(label))
                return item;
        }
        throw new RuntimeException("\nUnexpected value: " + label + ".\nPlease check api method value you use.");
    }

    public static List<RestMethod> getValuesExcept(RestMethod given) {
        List<RestMethod> result = new LinkedList<>();
        for (RestMethod item : RestMethod.values()) {
            if (item != given)
                result.add(item);
        }
        return result;
    }
}
