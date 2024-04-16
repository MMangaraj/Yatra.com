package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.CruisePage;

public class StepsforCruisePage {
	WebDriver driver;
	CruisePage Cp;
	
	@Given("User is mouse over on the +more in the navbar menu")
	public void user_is_mouse_over_on_the_more_in_the_navbar_menu() {
		Hooks.getLogger().info("----------------------------------");
		Hooks.getLogger().info("----------- CruisePage Test case Starts -----------");
		Hooks.getLogger().info("----------------------------------");
		Hooks.getLogger().info("User is on the Home Page");
		Hooks.getLogger().info("User Mouse over on the +more ");
		Cp = new CruisePage(Hooks.driver);
		Cp.moveToMore();
	    
	}

	@When("User select the curise on the list")
	public void user_select_the_curise_on_the_list() {
		Cp.selectCruiseFromMoreList();
		Hooks.getLogger().info("User Click on the Cruise ");
	    
	}

	@Then("User Click on the one Cruise Line")
	public void user_click_on_the_one_cruise_line() {
		Hooks.getLogger().info("User Click on the One Cruise Line");
	    Cp.clickonReadMore();
	}

	@Then("Display the all Inclusion Point of the cruise")
	public void display_the_all_inclusion_point_of_the_cruise() {
		Hooks.getLogger().info("Display the all Inclusion Points ");
		Cp.printInclusionPoints();
	    
	}

}
