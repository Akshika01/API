package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
    
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException{
		// write code to get place_id from the existing methods in step definitions file if place_id is null
		StepDefinitions sd= new StepDefinitions();
		if(StepDefinitions.place_id==null){
		sd.addplace_payload_with("Akshika", "French", "Guigues");
		sd.user_calls_with_http_request("AddPlaceApi", "POST");
		sd.verify_place_id_created_maps_to_using("Akshika", "GET");
		}
	}
}
