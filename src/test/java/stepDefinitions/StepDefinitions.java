package stepDefinitions;

import static io.restassured.RestAssured.given;

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
	@Given("AddPlace payload")
	public void addplace_payload() {
	    // Write code here that turns the phrase above into concrete actions		
		reqSpec= given().spec(requestSpecification()).body(TestDataBuild.addPlacePayload());			
	}

	@When("user calls {string} using post http request")
	public void user_calls_using_post_http_request(String string) {
		response=reqSpec.when().post("/maps/api/place/add/json").
				then().spec(responseSpecification()).extract().response();
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
	    String resp=response.asString();
	    JsonPath js=new JsonPath(resp);
	    assertEquals(js.getString(key),expectedValue);
	}
}
