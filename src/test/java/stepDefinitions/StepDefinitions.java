package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

public class StepDefinitions extends Utils {
	RequestSpecification reqSpec;	
	Response response;
	static String place_id;
	
	
	/*@Given("AddPlace payload")
	public void addplace_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions		
		reqSpec= given().spec(requestSpecification()).body(TestDataBuild.addPlacePayload());			
	}*/
	
	@Given("AddPlace payload with {string} {string} {string}")
	public void addplace_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		reqSpec= given().spec(requestSpecification()).body(TestDataBuild.addPlacePayload(name, language, address));	
	}

	/*@When("user calls {string} using post http request")
	public void user_calls_with_post_http_request(String string) {
		response=reqSpec.when().post("/maps/api/place/add/json").
				then().spec(responseSpecification()).extract().response();
		String respString=response.asString();		
		System.out.println(respString);
		
	}*/
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String ApiName, String ApiType) {
		
		if(ApiType.equalsIgnoreCase("POST")&& ApiName.equalsIgnoreCase("AddPlaceApi")){
			response=reqSpec.when().post("/maps/api/place/add/json").
					then().spec(responseSpecification()).extract().response();
		}
		
		else if(ApiType.equalsIgnoreCase("POST")&& ApiName.equalsIgnoreCase("deletePlaceApi")){
			response=reqSpec.when().post("/maps/api/place/delete/json").
					then().spec(responseSpecification()).extract().response();
		}
		
		else if(ApiType.equalsIgnoreCase("GET")){
			response=reqSpec.when().get("/maps/api/place/get/json").
					then().spec(responseSpecification()).extract().response();
		}
		
		String respString=response.asString();		
		System.out.println(respString);
	}

	@Then("the API call is success with status code {string}")
	public void the_API_call_is_success_with_status_code(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions	    
	    String actualValue=getJsonPath(response, key);
	    assertEquals(actualValue,expectedValue);
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String ApiMethod) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id=getJsonPath(response,"place_id");
	   reqSpec=given().spec(requestSpecification()).queryParam("place_id", place_id);
	   user_calls_with_http_request("getPlaceAPI", "GET");
	   String actualName=getJsonPath(response,"name");
	   assertEquals(actualName,expectedName);
	  
	   
			   	}
	
	@Given("Delete Place Payload")
	public void delete_Place_Payload() throws IOException {
		
	    // Write code here that turns the phrase above into concrete actions
	    reqSpec=given().spec(requestSpecification()).body(TestDataBuild.deletePlacePayload(place_id));
	    
	}
	
}
