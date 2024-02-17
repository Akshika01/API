Feature: Validating Place API's    
//Feature will tell whatwe are going to test say Login Feature

Scenario Outline: Verify place is added successfully using AddPlaceAPI
Given AddPlace payload with "<name>" "<language>" "<address>"
When  user calls "AddPlaceApi" with "POST" http request
Then  the API call is success with status code "200"
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created maps to "<name>" using "getPlaceApi"
 
Examples: 
 |name| language| address|
 |AAGarg|Punjabi|Ottawa|
# |AAMittal| Hindi| Windsor|

Scenario:  Verify if delete place functionality is working
Given Delete Place Payload
When user calls "deletePlaceApi" with "POST" http request
Then the API call is success with status code "200"
And "status" in response body is "OK"
