package utils;

import java.util.HashMap;

import io.cucumber.java.Scenario;

public class ScenarioStorage {
	static String baseURI;
	static String requestPayload;
	static String requestHeaders;
	static String requestMethod;
	static String responseBody;
	
    private static final HashMap<Thread, Scenario> map = new HashMap<>();

    public static void putScenario(Scenario scenario) {
        map.put(Thread.currentThread(), scenario);
        //requestPayload = scenario.
        		
    }

    public static Scenario getScenario() {
        return map.get(Thread.currentThread());
    }
    
    

}
