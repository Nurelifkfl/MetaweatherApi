package com.metaweather.utilities;

import com.metaweather.stepDefinitions.hooks;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.List;

import static io.restassured.RestAssured.*;

public class ApiUtils {
    int woeid;


    public int getWoeid(String location) {
        baseURI = ConfigurationReader.get("mw_URI");

        Response response = given().accept(ContentType.JSON)
                .queryParam("query", location).and()
                .when()
                .get("/location/search");

        List<String> weather= response.body().path("weather_state_name");
        System.out.println("weather= "+weather);


        Assert.assertEquals("Checking response status code 200", response.statusCode(), 200);

        try {

            woeid = response.jsonPath().getInt("woeid[0]");

        } catch (NullPointerException e) {
            System.out.println("This location is currently unavailable.");
        }
        return woeid;
    }

    public Response getLocationByDate(String woeid, String requestedDay){
        baseURI="https://www.metaweather.com/api";
        return  given().accept(ContentType.JSON).and().contentType(ContentType.JSON)
                .pathParam("location", woeid)
                .when()
                .get("/location/{location}/" + requestedDay);
    }


}
