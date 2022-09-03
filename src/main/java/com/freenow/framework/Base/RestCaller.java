package com.freenow.framework.Base;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestCaller {

    public Response doGet(String URI) {

        Response response = given().header("Content-Type", "application/json").
                when().get(URI).
                then().extract().response();

        return response;

    }

    public <T> List<T> doGetPOJO(String URI, Class pojoClass) {

        JsonPath response = given().header("Content-Type", "application/json").
                when().get(URI).
                then().extract().response().getBody().jsonPath();

        List<T> responsePOJO =  response.getList("$",pojoClass);
        return responsePOJO;

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
