package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features = {".//FeatureFiles"},
					glue ="stepDefinition",
					plugin = {"pretty", "html:reports/myreport.html",
							"rerun:target/rerun.txt",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					}
		
		
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
