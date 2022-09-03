package com.freenow.test;

import com.freenow.framework.Base.EndPoints;
import com.freenow.framework.Base.RestCaller;
import com.freenow.framework.Utility.Util;
import com.freenow.responsePOJO.CommentsPOJO;
import com.freenow.responsePOJO.PostsPOJO;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;

import org.testng.annotations.Test;


import java.util.*;

public class CommentsTest {

    HashMap<String, Object> user = new HashMap<>();
    PostsPOJO[] postArry;
    CommentsPOJO[] CommentArry;
    List<Integer> postId = new ArrayList<>();
    List<String> emails = new ArrayList<>();

    private final String jsonPath_username = "$.[?(@.username=='Samantha')].id";

    @Test(priority = 1)
    public void searchUser() {

        Response response = new RestCaller().doGet(EndPoints.baseURI + EndPoints.users);
        List<Object> userList = Util.getJsonValue(response, jsonPath_username);
        user.put("userId", userList.get(0));
        Assert.assertTrue(userList.size() != 0);
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test(dependsOnMethods = {"searchUser"}, priority = 2)
    public void verify_post() {

        Response response = new RestCaller().doGet(EndPoints.baseURI + EndPoints.posts);
        postArry = response.as(PostsPOJO[].class);
        for (PostsPOJO post : postArry) {
            if (post.getUserId() == (Integer) user.get("userId")) {
                postId.add(post.getId());
            }
        }

        Assert.assertTrue(postArry.length != 0);
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test(dependsOnMethods = {"verify_post"}, priority = 3)
    public void verify_email_in_comments() throws Exception {

        Response response = new RestCaller().doGet(EndPoints.baseURI + EndPoints.comments);
        CommentArry = response.as(CommentsPOJO[].class);

        for (CommentsPOJO post : CommentArry) {
            if (postId.contains(post.getPostId())) {
                if (EmailValidator.getInstance().isValid(post.getEmail())) {
                    System.out.println("Email valid : " + post.getEmail());
                } else {
                    throw new Exception("Invalid email found !!!");
                }
            }
        }


    }

}
