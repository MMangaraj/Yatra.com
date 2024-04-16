package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features = {".//FeatureFiles"},
					glue ="stepDefinition",
					plugin = {"pretty", "html:reports/myreport.html",
							"rerun:target/rerun.txt",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					},
					//tags ="@smoke"
					//tags = "@smoke and @regression"
					tags = "@smoke or @regression"
							
		
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
