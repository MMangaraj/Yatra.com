package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.GiftPage;

public class StepsforGiftPage {
	WebDriver driver;
	GiftPage Gp;
	
	@Given("User is mouse over on the +more icon in the NavBar")
	public void user_is_mouse_over_on_the_more_icon_in_the_nav_bar() {
		Hooks.getLogger().info("----------------------------------");
		Hooks.getLogger().info("------------ Gift Page Test Case Starts  ------------");
		Hooks.getLogger().info("----------------------------------");
		Hooks.getLogger().info("User is on the Home Page");
		Hooks.getLogger().info("User Mouse over on the +more ");
		this.driver=Hooks.driver;
		Gp = new GiftPage(driver);
		Gp.moveToMore();
	}

	@When("User is click on the Gift Voucher")
	public void user_is_click_on_the_gift_voucher() {
		Gp.selectGiftFromMoreList();
		Hooks.getLogger().info("User Clicked on the Gift Voucher from the List");
	    
	}

	@Then("User navigate to the Gift Voucher page")
	public void user_navigate_to_the_gift_voucher_page() {
		Gp.switchToGiftVoucher(driver);
		Hooks.getLogger().info("User is On GiftVoucher Page");
	   
	}

	@Then("User Scroll to corporate queries")
	public void user_scroll_to_corporate_queries() {
		Gp.scrolltocorporte();
		Hooks.getLogger().info("User Scroll to the Corporate Queries");
	    
	}

	@Then("User fill the Deatils")
	public void user_fill_the_deatils() throws InterruptedException, IOException {
		Gp.checkForEmailToolTip();
		Hooks.getLogger().info("Display the Email Error Message");
	   
	}

	@Then("Display the Error Message")
	public void display_the_error_message() throws InterruptedException, IOException {
		Gp.checkForPhoneToolTip();
		Hooks.getLogger().info("Display the Phone Error Message");
	    
	}

}
