Feature: Validating Place API's    
//Feature will tell whatwe are going to test say Login Feature

Scenario: Verify place is added successfully using AddPlaceAPI
Given AddPlace payload
When  user calls "AddPlaceApi" using post http request
Then  the API call is success with status code "200"
And "status" in response body is "OK"
And "scope" in response body is "APP"
 