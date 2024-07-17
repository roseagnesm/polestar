package endpoints;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	public  final static int SUCCESS_STATUS_CODE = 200;

	public  final static int GET_REQUEST = 0;
	public  final static int POST_REQUEST = 1;
	public  final static int DELETE_REQUEST = 2;
	public  final static int PUT_REQUEST = 3;

	protected String base_url;
	Properties properties;

	public BaseService() {
		properties = new Properties();
	}

	public void verifyResponseKeyValues(String key, String val, Response r) {
		String keyValue = r.jsonPath().getString(key);
		assertThat(keyValue, is(val));
	}

	public void verifyResponseStatusValue(Response response, int expectedCode) {
		assertThat(response.getStatusCode(), is(expectedCode));
	}

	public String getBaseUrl() {
		String environment;
		try {
			properties.load(new FileInputStream(new File(System.getProperty("user.dir") + "/Config/config.properties")));
			environment = properties.getProperty("environment");
			if(environment==null) {
				throw new Exception("Environment not set");
			}
			else
			{
				switch(environment)
				{
				case "QA":
					this.base_url = properties.getProperty("baseURL_QA");
					break;
				case "Dev":
					this.base_url = properties.getProperty("baseURL_Dev");
					break;
				case "PreProd":
					this.base_url = properties.getProperty("baseURL_PreProd");
					break;
				default:
					throw new Exception("Base URL not set");					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.exit(1);
		}		
		return this.base_url;
	}
	public RequestSpecification getRequestWithJSONHeaders() {
		RequestSpecification r = RestAssured.given();
		r.header("Content-Type", "application/json");
		return r;
	}

	protected JSONObject createJSONPayload(Object pojo) {
		return new JSONObject(pojo);
	}

	public Response sendRequest(RequestSpecification request, int requestType, String url, Object pojo, Map<String, String> queryParams) {
		Response response = null;

		// Add the Json to the body of the request
		if (null != pojo) {
			String payload = createJSONPayload(pojo).toString();
			request.body(payload);
			System.out.println(payload);
		}
        if(queryParams != null) {
        	request.queryParams(queryParams);
        }
		// need to add a switch based on request type
		switch (requestType) {
		case BaseService.GET_REQUEST:
			if (null == request) {
				response = RestAssured.when().get(url);
			} else {
				response = request.get(url);
			}
			break;
		case BaseService.POST_REQUEST:
			if (null == request) {
				response = RestAssured.when().post(url);
			} else {
				response = request.post(url);
			}
			break;
		case BaseService.DELETE_REQUEST:
			if (null == request) {
				response = RestAssured.when().delete(url);
			} else {
				response = request.delete(url);
			}
			break;
		case BaseService.PUT_REQUEST:
			if (null == request) {
				response = RestAssured.when().put(url);
			} else {
				response = request.put(url);
			}
			break;
		default:
			if (null == request) {
				response = RestAssured.when().post(url);
			} else {
				response = request.post(url);
			}
			response = request.post(url);
			break;
		}
		return response;
	}
}
