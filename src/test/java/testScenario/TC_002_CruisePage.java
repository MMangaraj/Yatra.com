package testScenario;

import org.testng.annotations.Test;

import pageObjects.CruisePage;
import testBase.BaseClass;

public class TC_002_CruisePage extends BaseClass {
	CruisePage CP;
	@Test (priority = 1)
	public void clickoncruise() {
		CP = new CruisePage(driver);
		
		CP.moveToMore();
		logger.info("Pointing to More");
		CP.selectCruiseFromMoreList();
		logger.info("Cruise is selected.");
		CP.clickonReadMore();
		logger.info("Clicked on ReadMore.");
	}
	@Test (priority = 2, dependsOnMethods= {"clickoncruise"})
	public void printallInclusion() {
		CP.printInclusionPoints();
		logger.info("Inclusion Points is Printed.");
	}
}
