package stepDefinition;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.HotelPage;

public class StepsforHotelSearch{
	WebDriver driver;
	HomePage Hp;
	HotelPage Hl;
	
	@Given("User click on Hotel Navbar")
	public void user_click_on_hotel_navbar() {
		Hooks.getLogger().info("----------------------------------");
		Hooks.getLogger().info("----- Hotel Search Test Case Starts ------");
		Hooks.getLogger().info("----------------------------------");
		Hooks.getLogger().info("User is On Yatra.com Page");
		Hp = new HomePage(Hooks.driver);
	    Hp.clickonHotels();
	    Hooks.getLogger().info("User Clicked on the Hotel Navbar");
	   
	}

	@When("User Enter the Hotel Loaction")
	public void user_enter_the_hotel_loaction() throws InterruptedException {
		Thread.sleep(3000);
		Hp.selectCity("Pune");
		Hooks.getLogger().info("User Entered the Location");
		
	    
	}

	@Then("User pickup the checkout date after five days from tomorrow's date")
	public void user_pickup_the_checkout_date_after_five_days_from_tomorrow_s_date() {
		Hp.selectCheckoutDate();
		Hooks.getLogger().info("User Pickup the Checkout Date");
		
	    
	}

	@Then("User add four People")
	public void user_add_four_people() {
		Hp.clickonTravellerDropDown();
		Hp.addTravellers();
		Hooks.getLogger().info("User add 4 Pepoles");
		
	   
	}

	@Then("User Click on Search buttton")
	public void user_click_on_search_buttton() {
		Hp.clickonSearchButton();
		Hooks.getLogger().info("User Clicked on the Search Button");
		
	    
	}

	@Then("User Click on the user rating")
	public void user_click_on_the_user_rating() {
		Hl = new HotelPage(Hooks.driver);
	   Hl.clickonUserRating();
	   Hooks.getLogger().info("User Clicked on the User Rating");
	   
	}

	@Then("User Click on all amenities")
	public void user_click_on_all_amenities() throws InterruptedException {
		Thread.sleep(1000);
	   Hl.selectfreewifi();
	   Hooks.getLogger().info("User Clicked on the FreeWifi Checkbox");
	   
	   Thread.sleep(1000);
	   Hl.selectfreebreakfast();
	   Hooks.getLogger().info("User Clicked on the FreeBreakFast Checkbox");
	   
	   Thread.sleep(1000);
	   Hl.selectswimmingpool();
	   Hooks.getLogger().info("User Clicked on the Swimmingpool Checkbox");
	   
	   Thread.sleep(1000);
	   Hl.selectlaundryfacilites();
	   Hooks.getLogger().info("User Clicked on the laundryfacilites Checkbox");
	   
	}

	@Then("Display the top {int} hotels from the hotel list")
	public void display_the_top_hotels_from_the_hotel_list(Integer int1) {
		Hl.displayHotelNamesAndPrices();
		Hooks.getLogger().info("Displayed the Top 3 Hotels");
		
	    
	}
}
