package data;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


public class ExcelReaderTest {

    private static final String FILEPATH = "src/test/resources/weather_stack_api.xlsx";
    private static final ExcelReader FILE = new ExcelReader(FILEPATH);

    private static final String COMMON_SHEET_NAME = "common";
    private static final String METHOD = "method";
    private static final String ENDPOINT = "endpoint";
    private static final String QUERY_PARAMS_SHEET_NAME = "query_params";


    @Test
    public void validateReadingExcel() {
        // get common data
        List<Map<String, Object>> common = FILE.readTestingDataFromSheet(COMMON_SHEET_NAME);
        for(Map<String, Object> testingData : common)
            System.out.println(testingData.get(METHOD) + " : " + testingData.get(ENDPOINT));
        System.out.println("----------------");

        // get query params
        List<Map<String, Object>> queryParams = FILE.readTestingDataFromSheet(QUERY_PARAMS_SHEET_NAME);
        for(Map<String, Object> testingData : queryParams)
            System.out.println("query : " + testingData.get("query"));
    }
}
