package com.metaweather.utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.List;

import static io.restassured.RestAssured.*;

public class ApiUtils {
    int woeid;
    String weather_state_name;


    public int getWoeid(String location) {
        baseURI = ConfigurationReader.get("mw_URI");

        Response response = given().accept(ContentType.JSON)
                .queryParam("query", location).and()
                .when()
                .get("/location/search");


        Assert.assertEquals("Checking response status code 200", response.statusCode(), 200);

        try {

            woeid = response.jsonPath().getInt("woeid[0]");

        } catch (NullPointerException e) {
            System.out.println("This location is currently unavailable.");
        }
        return woeid;
    }

    public Response getLocationByDate(String woeid, String requestedDay){
        baseURI = ConfigurationReader.get("mw_URI");
        return  given().accept(ContentType.JSON)
                .pathParam("location", woeid)
                .when()
                .get("/location/{location}/" + requestedDay);
    }


    public void getWeather(String woeid, String requestedDay){
        baseURI = ConfigurationReader.get("mw_URI");
        Response response= given().accept(ContentType.JSON)
                            .when().get("/location/"+woeid+"/"+requestedDay);
       JsonPath jsonData = response.jsonPath();
       String weather = jsonData.getString("weather_state_name[0]");

       System.out.println(weather);



    }
        }
