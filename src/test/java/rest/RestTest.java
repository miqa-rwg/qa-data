package rest;

import io.restassured.filter.time.TimingFilter;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RestTest {

    String baseUrl = "http://api.weatherstack.com";
    String endpoint = "/current";
    RestMethod method = RestMethod.GET;
    String key = "f9da7fc0f60c688677bbbef6220f6451";
    String location = "Toronto";
    Rest api = new Rest
            .Builder(baseUrl, endpoint, method)
            .queryParams(queryParams())
            .build();


    @Test
    public void validateBuilder() {
        Response response = api.executeRequest();
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void validateGetter() {
        assertEquals(baseUrl, api.getBaseUrl());
    }

    @Test
    public void validateBuilderAddingUnrealData() {
        Response response = new Rest
                .Builder(baseUrl, endpoint, method)
                .listeners(new TimingFilter())
                .oauth2("token")
                .headers(headers())
                .queryParams(queryParams())
                .body("")
                .build()
                .executeRequest();
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());
    }


    private List<RestParameter> queryParams() {
        List<RestParameter> result = new LinkedList<>();
        result.add(new RestParameter("access_key", key));
        result.add(new RestParameter("query", location));
        return result;
    }

    private List<RestParameter> headers() {
        List<RestParameter> result = new LinkedList<>();
        result.add(new RestParameter("accept", "*/*"));
        return result;
    }
}
