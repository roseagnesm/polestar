Feature: Reqres API

@smokeTest	
Scenario: GET Request for List Users
    Given Baseuri is provided
    When I send GET request to get details
    Then the order request response has a '200' response code
    And the order requests response contains the correct json data

@smokeTest  
Scenario: POST Request for Users
    Given Baseuri is provided
    When I send POST request to create User
    Then the order request response has a '201' response code
    And the order requests response contains the correct json data
			
Scenario: PUT Request for Users
    Given Baseuri is provided
    When I send PUT request to update User
    Then the order request response has a '200' response code
    And the order requests response contains the correct json data

Scenario: DELETE Request for Users
    Given Baseuri is provided
    When I send DELETE request to delete User
    Then the order request response has a '204' response code