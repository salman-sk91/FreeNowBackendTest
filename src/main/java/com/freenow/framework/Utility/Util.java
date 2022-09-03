package com.freenow.framework.Utility;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Util {

    public static List<Object> getJsonValue(Response response, String jsonPath){

        return JsonPath.parse(response.asPrettyString()).read(jsonPath);

    }

    public static boolean validateEmail(String email){

        return EmailValidator.getInstance().isValid(email);

    }

}
