package testScenario;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.HotelPage;
import testBase.BaseClass;

public class TC_001_HotelSearchPage extends BaseClass {
	
	HomePage Hp;
	HotelPage Hl;
	@Test(priority = 1)
	public void clickonHotel() {
		logger.info("********** TC_HotelSearchPage Test Start ******************");
		Hp = new HomePage(driver);
		Hp.clickonHotels();
		logger.info("Clicked on Hotel Navbar");
				
	}
	@Test(priority = 2,dependsOnMethods= {"clickonHotel"})
	public void selectHotel() {
		try {
			Hp.selectCity("pune");
			logger.info("City is Selected");
			Hp.selectCheckoutDate();
			logger.info("CheckOut Date is Selected.");
			Hp.clickonTravellerDropDown();
			Hp.addTravellers();
			logger.info("Added Travellers Upto 4");
			Hp.clickonSearchButton();
			logger.info("Clicked on SearchButton.");

		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test (priority = 3)
	public void selectallaminites() {
		Hl = new HotelPage(driver);
		Hl.clickonUserRating();
		logger.info("Clicked on UserRating.");
//		Hl.selectAllAminities();
		Hl.selectfreewifi();
		Hl.selectfreebreakfast();
		Hl.selectswimmingpool();
		Hl.selectlaundryfacilites();
		logger.info("All Aminites is Selected.");
	}
	@Test (priority = 4)
	public void displayhotels() {
		Hl.displayHotelNamesAndPrices();
		logger.info("Hotel is Displayed.");
	}

}
