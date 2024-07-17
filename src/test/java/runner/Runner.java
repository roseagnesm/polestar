package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/rest/resources"},
      //tags= "@Get",
	tags= "@Post",
	//tags= "@Delete",
	//tags= "@Put",
	glue= {"stepdefs"},
    plugin = 
    { 
    		"pretty","html:target/reports/test-report/index.html" ,
			"junit:target/cucumber-reports/Cucumber.xml",
		 	"json:target/reports/test-report/cucumber.json" ,
		 	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	},
	monochrome = true
)

public class Runner {
	
	/*
	 * public static void writeExtentReport() { Reporter.loadXMLConfig(new
	 * File("src/test/resources/extent-config.xml")); }
	 */
}

