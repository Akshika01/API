package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceRequest;
import pojo.Location;

public class TestDataBuild {
public static AddPlaceRequest addPlacePayload(String name, String lang, String addr){
	AddPlaceRequest apr=new AddPlaceRequest();
	apr.setAccuracy(50);
	apr.setAddress(addr);
	apr.setLanguage(lang);
	apr.setName(name);
	apr.setPhone_number("(+91) 983 893 3937");
	apr.setWebsite("http://google.com");
	List<String> myList= new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	apr.setTypes(myList);
	Location l=new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	apr.setLocation(l);
	
	return apr;
	
	
}

public static String deletePlacePayload(String placeId){
	return "{\r\n" + 
			"\"place_id\":\""+placeId+"\"\r\n" + 
			"}";
}
}
