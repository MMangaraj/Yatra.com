package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver Driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "booking_engine_hotels")
	WebElement hotels;
	
	@FindBy(name = "BE_hotel_destination")
	WebElement hoteldestination;
	
	@FindBy(id = "BE_hotel_checkout_date")
	WebElement checkoutdate;
	
	@FindBy(xpath = "//*[@id='month-scroll0']/div/div/table/tbody/tr/td")
	List<WebElement> listofdates;
	
	@FindBy(xpath = "//i[@class='icon icon-angle-right arrowpassengerBox']")
	WebElement travellerdropdown;
	
	@FindBy(xpath = "(//span[@class='ddSpinnerPlus'])[1]")
	WebElement addtravellers;
	
	@FindBy(xpath = "//input[@id='BE_hotel_htsearch_btn']")
	WebElement clickonsearchbutton;
	
	
	public void clickonHotels() {
		hotels.click();
		System.out.println("clicked on hotels");
	}
	
	public void selectCity(String city) throws InterruptedException {
		Thread.sleep(1000);
		hoteldestination.click();
		Thread.sleep(1000);
		hoteldestination.clear();
		hoteldestination.sendKeys(city);
		Thread.sleep(1000);
		hoteldestination.sendKeys(Keys.ENTER);
		System.out.println(city + " is selected");
	}
	
	public void selectCheckoutDate() {
		LocalDate tomorrowsDate = LocalDate.now().plusDays(1); // gives tomorrows date
		System.out.println("Check-in Date : " + tomorrowsDate);
		checkoutdate.click();
		LocalDate checkoutdate = LocalDate.now().plusDays(5);
		System.out.println("Check-out Date : " + checkoutdate);

		String formatedDate = checkoutdate.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
		String date = formatedDate.substring(0, 2);
		for (int i = 1; i < listofdates.size(); i++) {
			if (listofdates.get(i).getText().equals(date)) {
				listofdates.get(i).click();
				break;
			}

		}
		System.out.println("checkout date selected");
	}
	
	public void clickonTravellerDropDown() {
		travellerdropdown.click();
		System.out.println("clicked on traveller drop down");
	}
	
	public void addTravellers() {
		addtravellers.click();
		addtravellers.click();
		System.out.println("2 traveller added");
	}
	
	public void clickonSearchButton() {
		clickonsearchbutton.click();
		System.out.println("clicked on search button");
	}
	
}
