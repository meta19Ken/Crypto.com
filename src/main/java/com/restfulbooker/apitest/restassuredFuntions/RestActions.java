package com.restfulbooker.apitest.restassuredFuntions;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.restfulbooker.apitest.utilities.Constants;

public class RestActions {
    private static RequestSpecification request;

    public static void initialize() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("base.url");
        requestSpecBuilder.setContentType(ContentType.JSON);
        request = RestAssured.given().spec(requestSpecBuilder.build());
    }

    
    public List<?> getDataAsList(String endPoint, Class<?> className, String instrumentName, String timeframe) {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put(Constants.INSTRUMENT_NAME, instrumentName);
        // As timeframe variable is empty for Trades
        if (!timeframe.isEmpty()) {
            requestParams.put(Constants.TIMEFRAME, timeframe);
        }
        Response response = request.params(requestParams).get(endPoint);
        return response.jsonPath().getList(Constants.DATA_JSON_PATH, className);
    }

}
