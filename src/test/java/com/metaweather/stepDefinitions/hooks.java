package com.metaweather.stepDefinitions;

import org.junit.Before;
import com.metaweather.utilities.ConfigurationReader;
import static io.restassured.RestAssured.baseURI;


public class hooks {

    @Before
    public void setUpApi(){
       baseURI = ConfigurationReader.get("mw_URI");


    }
}
