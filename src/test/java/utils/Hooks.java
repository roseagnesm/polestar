package utils;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    @Before(order = 1)
    public void getScenario(Scenario scenario) {
        ScenarioStorage.putScenario(scenario);
    }
    
	
	 @After
	 public void addInfotoReports(Scenario scenario) {
	 scenario.attach("","", "");
	 }
	 
}