package data;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import rest.RestParameter;

import java.util.LinkedList;
import java.util.List;


public class JsonConverterTest {

    @Test
    public void checkObjectToJson() {
        RestParameter parameter = new RestParameter("param1", "value1");

        String json = new JsonConverter().toJson(parameter, false);
        System.out.println(json);
    }

    @Test
    public void checkObjectToJsonWithNull() {
        RestParameter parameter = new RestParameter("param1", null);

        String json = new JsonConverter().toJson(parameter, true);
        System.out.println(json);
    }

    @Test
    public void checkListOfObjectsToJson() {
        List<RestParameter> list = new LinkedList<>();
        for (int index = 0; index < 10; index++)
            list.add(new RestParameter("param" + index, "value" + index));

        String json = new JsonConverter().toJson(list, false);
        System.out.println(json);
    }

    @Test
    public void checkJsonToObject() {
        String json = "{\"key\":\"param2\",\"value\":\"value2\"}";

        RestParameter parameter = new JsonConverter().toObject(json, new TypeReference<>(){});
        System.out.println(parameter.getKey());
        System.out.println(parameter.getValue());
    }

    @Test
    public void checkJsonToListOfObjects() {
        String json = "[ {\n" +
                "  \"key\" : \"param0\",\n" +
                "  \"value\" : \"value0\"\n" +
                "}, {\n" +
                "  \"key\" : \"param1\",\n" +
                "  \"value\" : \"value1\"\n" +
                "}, {\n" +
                "  \"key\" : \"param2\",\n" +
                "  \"value\" : \"value2\"\n" +
                "} ]";

        List<RestParameter> parameters = new JsonConverter().toObject(json, new TypeReference<>(){});

        for (RestParameter parameter : parameters) {
            System.out.println(parameter.getKey());
            System.out.println(parameter.getValue());
            System.out.println();
        }
    }
}