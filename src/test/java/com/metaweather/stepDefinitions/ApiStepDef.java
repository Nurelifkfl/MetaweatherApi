package com.metaweather.stepDefinitions;

import com.metaweather.utilities.ApiUtils;
import com.metaweather.utilities.DateUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.util.Date;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.core.IsNull.notNullValue;

public class ApiStepDef {

    int woeid;
    Response response=null;

    @Given("the user is a MetaWeather client")
    public void the_user_is_a_MetaWeather_client() {
    //No authorization is needed its a public API
    //if it's not, I would generate access token for authentication header

        System.out.println(baseURI);
    }

    @When("the user looks up the weather for {string} and date of {string}")
    public void the_user_looks_up_the_weather_for_and_date_of(String location, String date) {

        String requestedDay = new DateUtils().processDate(date);

        woeid= new ApiUtils().getWoeid(location);
        System.out.println(location + "'s woeid is "+woeid);

        response = new ApiUtils().getLocationByDate(String.valueOf(woeid),requestedDay);
        System.out.println(location+"-"+date);



    }
    @Then("the endpoint should return status code {int}")
    public void the_endpoint_should_return_status_code(Integer statusCode) {

        response.then().assertThat().statusCode(statusCode);
       // System.out.println(statusCode);

    }
    @Then("the content type should be {string}")
    public void the_content_type_should_be(String contentType) {
        response.then().assertThat().contentType(contentType.toLowerCase());

       // System.out.println(contentType);


    }

    @Then("the payload {string} should not be null")
    public void the_payload_should_not_be_null(String id) {

        response.then().assertThat().body(id, everyItem(notNullValue()));


    }

    @And("the payload data should reflect the date of {string}")
    public void thePayloadDataShouldReflectTheDateOf(String date) {
        String reqDate = new DateUtils().swapDateFormat(new DateUtils().processDate(date));
        response.then().assertThat().body("applicable_date", everyItem(equalTo(reqDate)));
    }


}
