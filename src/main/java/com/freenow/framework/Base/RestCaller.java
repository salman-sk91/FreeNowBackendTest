package com.freenow.framework.Base;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestCaller {

    public Response doGet(String URI, Map<String,Object> params) {
        Response response;
        if(params!=null) {
             response = given().header("Content-Type", "application/json").
                    queryParams(params).
                    when().get(URI).
                    then().extract().response();
        }else {
             response = given().header("Content-Type", "application/json").
                    when().get(URI).
                    then().extract().response();
        }
        return response;

    }

    public Response doPost(String URI, String body) {

        Response response = given().header("Content-Type", "application/json").
                when().body(body).post(URI).
                then().extract().response();

        System.out.println("Response Received: " + response.statusCode());
        return response;

    }

    public Response doDelete(String URI, String body) {

        Response response = given().header("Content-Type", "application/json").
                when().body(body).delete(URI).
                then().extract().response();

        System.out.println("Response Received: " + response.statusCode());
        return response;

    }

    public Response doPut(String URI, String body) {
        Response response = given().header("Content-Type", "application/json").
                when().body(body).put(URI).
                then().extract().response();

        System.out.println("Response Received: " + response.statusCode());
        return response;

    }
}
