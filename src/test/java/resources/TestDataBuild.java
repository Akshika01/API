package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceRequest;
import pojo.Location;

public class TestDataBuild {
public static AddPlaceRequest addPlacePayload(){
	AddPlaceRequest apr=new AddPlaceRequest();
	apr.setAccuracy(50);
	apr.setAddress("29, side layout, cohen");
	apr.setLanguage("French-IN");
	apr.setName("FrontLine House");
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
}
