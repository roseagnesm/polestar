package utils;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.*;

public class ReportHelper {
	public static void addRequestResponseToHtmlReport(QueryableRequestSpecification request, Response response,
			String baseUrl) {
		if (baseUrl != null) {
			// ScenarioStorage.getScenario().attach(data, mediaType, name);("baseUrl :"+
			// baseUrl);
			// ScenarioStorage.getScenario().write("Request:");
		}

		if (request != null) {
			// ScenarioStorage.getScenario().write("Headers :"+ request.getHeaders());
			// ScenarioStorage.getScenario().write("HttpMethod :"+ request.getMethod());
			// ScenarioStorage.getScenario().write("Body :"+ request.getBody());
		}

		if (response != null) {
			// ScenarioStorage.getScenario().write("Response:"+response.prettyPrint());
		}
	}
	
    public static void generateCucumberReport() {
        File reportOutputDirectory = new File("target");
        ArrayList<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");

        String projectName = "testng-cucumber";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "release/1.0");

        // optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<String>();
        classificationFiles.add("src/test/resources/config/config.properties");
        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
	
}