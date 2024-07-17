package stepdefs;


import java.util.List;
import java.util.Map;

import endpoints.Reqres;
import endpoints.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.student;



public class ReqresEndpointStepDefinitions {

	private World world;
	private Reqres userEndpoint = new Reqres();

	public ReqresEndpointStepDefinitions(World world) {
		this.world = world;
	}
	
	@Given("Baseuri is provided")
	public void baseuri_is_provided() {
		System.out.println(" ");
	    
	}
	@When("I send GET request to get details")
	public void i_send_get_request_to_get_details() {
		world.setRequest(userEndpoint.getRequestWithJSONHeaders());
		world.setResponse(userEndpoint.getUser(world.getRequest()));
		System.out.println(world.getResponse().getBody().asString());
		//System.out.println(world.getResponse().prettyPrint());
	}
	
	@When("I send POST request to create User")
	public void i_send_post_request_to_create_user(io.cucumber.datatable.DataTable student) {
		world.setRequest(userEndpoint.getRequestWithJSONHeaders());
		List<Map<String, String>> rows = student.asMaps(String.class, String.class);
		for (Map<String, String> columns : rows)
		{
		world.setResponse(userEndpoint.createUser(world.getRequest(), new student(columns.get("name"), columns.get("std"),Integer.parseInt(columns.get("rollno")))));	
		}
		System.out.println(world.getResponse().getBody().asString());
	}
	@When("I send PUT request to update User")
	public void i_send_put_request_to_update_user(io.cucumber.datatable.DataTable student) {
		world.setRequest(userEndpoint.getRequestWithJSONHeaders());
		List<Map<String, String>> rows = student.asMaps(String.class, String.class);
		for (Map<String, String> columns : rows)
		{
		world.setResponse(userEndpoint.updateUser(world.getRequest(), new student(columns.get("name"), columns.get("std"),Integer.parseInt(columns.get("rollno")))));	
		}
		System.out.println(world.getResponse().getBody().asString());
	}
	
	@When("I send DELETE request to delete User")
	public void i_send_delete_request_to_delete_user(io.cucumber.datatable.DataTable dataTable) {
		world.setRequest(userEndpoint.getRequestWithJSONHeaders());
		List<Map<String, String>> params = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> columns : params) {
			world.setResponse(userEndpoint.deleteUser(world.getRequest(),columns ));
			}
		System.out.println(world.getResponse().getBody().asString());
	}
	
    @Then("^the order request response has a '(\\d+)' response code$")
	public void the_response_has_the_correct_response_code(Integer rc) {
		userEndpoint.verifyResponseStatusValue(world.getResponse(), rc.intValue());
		System.out.println(world.getResponse().getStatusCode());
		}
	
	@Then("^the order requests response contains the correct json data$")
	public void the_json_response_contains_the_correct_data(io.cucumber.datatable.DataTable verifyres) {
		List<Map<String, String>> rows = verifyres.asMaps(String.class, String.class);
		for (Map<String, String> columns : rows)
		{
			userEndpoint.verifyResponseKeyValues(columns.get("key"), columns.get("value"), world.getResponse());	
		}
		}
	}
