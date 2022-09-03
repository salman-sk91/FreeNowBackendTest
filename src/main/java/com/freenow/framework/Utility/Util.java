package com.freenow.framework.Utility;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class Util {

    public static List<Object> getJsonValue(Response response, String jsonPath){

        return JsonPath.parse(response.asPrettyString()).read(jsonPath);

    }


}
