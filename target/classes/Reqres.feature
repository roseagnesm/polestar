Feature: Reqres API

@Get	
Scenario: GET Request for List Users
    Given Baseuri is provided
    When I send GET request to get details
    Then the order request response has a '200' response code
    And the order requests response contains the correct json data
    | key           | value  |
    | questionId[0] | 210002 |
@Post  
Scenario: POST Request for Users
    Given Baseuri is provided
    When I send POST request to create User
    | name | std | rollno |
    | Rose | III | 123    |
    Then the order request response has a '201' response code
    And the order requests response contains the correct json data
    | key  | value |
    | name | Rose  |
@Put		
Scenario: PUT Request for Users
    Given Baseuri is provided
    When I send PUT request to update User
    | name  | std | rollno |
    | Agnes | III | 121    |
    Then the order request response has a '201' response code
    And the order requests response contains the correct json data
    | key  | value |
    | name | Agnes |
@Delete
Scenario: DELETE Request for Users
    Given Baseuri is provided
    When I send DELETE request to delete User
    | rollNo |
    | 101    |
    Then the order request response has a '200' response code