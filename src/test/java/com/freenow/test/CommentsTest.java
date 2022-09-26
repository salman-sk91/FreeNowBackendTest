package com.freenow.test;

import com.freenow.DataContainer.LocalDataContainer;
import com.freenow.framework.Base.BaseAPI;
import com.freenow.framework.Base.EndPoints;
import com.freenow.framework.Base.RestCaller;
import com.freenow.framework.Utility.Constants;
import com.freenow.framework.Utility.Util;
import com.freenow.responsePOJO.CommentsPOJO;
import com.freenow.responsePOJO.PostsPOJO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class CommentsTest extends BaseAPI {


    LocalDataContainer data = new LocalDataContainer();


    @Test(priority = 1)
    public void search_and_verify_user() {
        Log.info("Searching for the user");
        Response response = new RestCaller().doGet(EndPoints.baseURI + EndPoints.users, null);
        List<Object> userList = Util.getJsonValue(response, Constants.jsonPath_username.replaceAll("#userName", (String) getProperty("username")));
        Assert.assertTrue(userList.size() != 0, "No User Found with username: " + getProperty("username"));
        Assert.assertEquals(response.statusCode(), 200);
        data.addDataMap("userId", userList.get(0));
        Log.info("Verified the user");

    }

    @Test(dependsOnMethods = {"search_and_verify_user"}, priority = 2)
    public void verify_post_on_users_blog() {
        Log.info("Verifying the post on Users blog");
        Response response = new RestCaller().doGet(EndPoints.baseURI + EndPoints.posts, data.dataMap);
        PostsPOJO[] postArry = response.as(PostsPOJO[].class);
        for (PostsPOJO post : postArry) {
            if (post.getUserId() == (Integer) data.getDataMap("userId")) {
                data.addDataList((post.getId()));
            }
        }

        Assert.assertTrue(postArry.length != 0, "No Post found for UserId " + data.getDataMap("userId"));
        Assert.assertEquals(response.statusCode(), 200);
        Log.info("Verified the post on Users blog");

    }

    @Test(dependsOnMethods = {"verify_post_on_users_blog"}, priority = 3)
    public void verify_email_in_comments() {
        Log.info("Verifying email on comments");
        for (Object postid : data.dataList) {
            Response response = new RestCaller().doGet(EndPoints.baseURI + EndPoints.comments, Map.of("postId", postid));
            CommentsPOJO[] CommentArry = response.as(CommentsPOJO[].class);
            Assert.assertTrue(CommentArry.length != 0, "No Commments found for postId " + postid);

            for (CommentsPOJO post : CommentArry) {
                Assert.assertTrue(Util.validateEmail(post.getEmail()), "Invalid email found: " + post.getEmail());
            }
        }
        Log.info("Verified email on comments");
    }

    @Test()
    public void verifyLocalAPI(){
        Log.info("Verifying local rest Service on circle ci");
        Response response = new RestCaller().doGet("http://192.168.1.3:8090/icon/models/plan/786/subplan/1",null);
        Log.info(response.asPrettyString());
        Assert.assertEquals(200,response.statusCode());
    }
}
