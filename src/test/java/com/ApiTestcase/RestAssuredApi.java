package com.ApiTestcase;

/*import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;*/
import com.gargoylesoftware.htmlunit.javascript.host.fetch.Headers;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

//import javax.xml.ws.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.http.ContentType.JSON;
import static org.testng.Assert.assertTrue;

public class RestAssuredApi {

    RequestSpecification request;
    Response response;

        @Test
    public void call_xapi_service() {

        //  Response response= RestAssured.get("https://www.healthcare.gov/api/topics.json");
        RequestSpecification request=RestAssured.given();
        //RestAssured.baseURI ="https://www.healthcare.gov/api/topics.json";
        Response response = get("https://www.healthcare.gov/api/topics.json");
        int statuscode = response.statusCode();

        System.out.println("statuscode:" + statuscode);
        Assert.assertEquals(statuscode, 200);
        System.out.println(response.headers());
        io.restassured.http.Headers allHeaders=response.headers();
        for(Header header : allHeaders) {
            System.out.println("Value"+header.getValue()+"Uma:"+header.getName());
        }
        String contenttype=response.header("Content-Type");
        Assert.assertEquals(contenttype, "application/json");

        String contentEncoding=response.header("Content-Encoding");
        System.out.println("Content-Encoding"+contentEncoding);
        Assert.assertEquals(contentEncoding,"gzip");

    }
    @Test
    public void RegistrationSuccessful()
    {
      //  RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
         request = RestAssured.given();
        request.header("content_type","application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "uma"); // Cast
        requestParams.put("LastName", "majji");
        requestParams.put("UserName", "majjiuma2019");
        requestParams.put("Password", "password1");

        requestParams.put("Email","umasample@gmail.com");
        request.body(requestParams.toString());
         response = request.post("/register");
        Response respo = request.get("/Chennai");

        //VERIFY THE CONTENT LENGTH
        io.restassured.http.Header content_length =response.headers().get("Content-Length");
        System.out.println(content_length);
        Assert.assertTrue(true,String.valueOf(content_length));
        //verify the content type
        String contenttype=response.header("Content-Type");
        System.out.println(contenttype);
        Assert.assertEquals(contenttype,"application/json");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
      //  Assert.assertEquals(statusCode,200);
        System.out.println(requestParams.get("FirstName"));
        ResponseBody responseBody=respo.getBody();
        System.out.println(responseBody.asString());
        String body=responseBody.asString();
        Assert.assertTrue(true,body);

    }
    //print the complete data in the form of string
    @Test
    public void call_xapi_service_tostring() {
        Response response = get("http://restapi.demoqa.com/utilities/weather/city=hyderabad");
       // Response response = get("https://www.healthcare.gov/api/topics.json");
      //  request.get("http://restapi.demoqa.com/utilities/weather/city=hyderabad");
        int statuscode = response.statusCode();
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.asString());
        System.out.println("time:" + response.getTime());
    }

    @Test
    public void post() {
        //String restAPIUrl="https://www.healthcare.gov/api/topics.json";
        RequestSpecification rest = RestAssured.given();
        //Add a header stating the Request body is a JSON
        rest.header("Content-Type", "application/json");


        Response response = RestAssured.given().contentType("application/json")
                .get("https://www.healthcare.gov/api/topics.json");
        // JSONObject JSONResponseBody = new JSONObject();
        String body = response.getBody().asString();
        System.out.println("result" + body);

        response = RestAssured.given()
                .contentType("application/json").

                        body("\"order\": \"<11>\",\r\n" +
                                "		\"meta-title\": \"<Get Insurance Health Insurance Marketplace>\"\r\n" +
                                "").
                        when().
                        post("https://www.healthcare.gov/api/topics.json");
        String body_post = response.getBody().asString();
        System.out.println(body_post);
        System.out.println("log" + rest.log().body());

    }
}