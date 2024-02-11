package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	RequestSpecification req;
	ResponseSpecification respSpec;
public RequestSpecification requestSpecification(){
	req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
			addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	return req;	
}

public  ResponseSpecification responseSpecification(){
	respSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();	
	return respSpec;
	
}
}
