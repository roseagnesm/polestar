package endpoints;

import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.student;


public class Reqres extends BaseService {
	private final String REQRESGET_ENDPOINT_PATH = "AmigoWallet/RegistrationAPI/getAllQuestions";
	private final String REQRESPOST_ENDPOINT_PATH = "rest-session-demo/api/student";
	private final String REQRESPUT_ENDPOINT_PATH = "rest-session-demo/api/student?rollNo=123";
	private final String REQRESDELETE_ENDPOINT_PATH = "rest-session-demo/api/student/delete";
	
	public String getPath() {
		return this.REQRESGET_ENDPOINT_PATH;
     }
	public String postPath() {
		return this.REQRESPOST_ENDPOINT_PATH;
     }
	public String putPath() {
		return this.REQRESPUT_ENDPOINT_PATH;
     }
	public String deletePath() {
		return this.REQRESDELETE_ENDPOINT_PATH;
     }
	public Reqres() {
		super();
	}
	public Response getUser(RequestSpecification request) {
		String url = getBaseUrl() + this.getPath();
		return sendRequest(request, BaseService.GET_REQUEST, url, null, null);
	}
	
	public Response createUser(RequestSpecification request, student student) {
		String url = getBaseUrl() + this.postPath();
		return sendRequest(request, BaseService.POST_REQUEST, url, student, null);
		
	}
	public Response updateUser(RequestSpecification request, student student) {
		String url = getBaseUrl() + this.putPath();
		return sendRequest(request, BaseService.PUT_REQUEST, url, student, null);
		
	}
	public Response deleteUser(RequestSpecification request, Map<String, String> columns) {
		String url = getBaseUrl() + this.deletePath();
		return sendRequest(request, BaseService.DELETE_REQUEST, url, null, columns);
		
	}

}
