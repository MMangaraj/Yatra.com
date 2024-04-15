package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPage extends BasePage {
	WebDriver driver;
	public HotelPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[normalize-space()='User Rating']")
	WebElement clickonuserrating;
	
	@FindBy(xpath = "//div[@class='full filter-wrapper accordion-wrappper accordion-anim-1']//label")
	private static List<WebElement> checkboxlist;
	
	@FindBy(xpath = "//h2[@class='hotel-name full fs-18 three-dot']")
	List<WebElement> hotelnamelist;

	@FindBy(xpath = "//div[@class='result-details-right show-gt-768 pr']//p/span/span[2]")
	List<WebElement> hotelpricelist;
	
	
	public void clickonUserRating() {
		clickonuserrating.click();
		System.out.println("clicked on user rating");
	}

	public void selectfreewifi() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < checkboxlist.size(); i++) {
			String str = checkboxlist.get(i).getText();
			if (str.contains("Free WiFi ")) {
				checkboxlist.get(i).click();
				break;
			}
		}
	}
	
	public void selectfreebreakfast() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < checkboxlist.size(); i++) {
			String str = checkboxlist.get(i).getText();
			if (str.contains("Free Breakfast ")) {
				checkboxlist.get(i).click();
				break;
			}
		}
	}
	
	public void selectswimmingpool() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < checkboxlist.size(); i++) {
			String str = checkboxlist.get(i).getText();
			if (str.contains("Swimming pool ")) {
				checkboxlist.get(i).click();
				break;
			}
		}
	}
	
	public void selectlaundryfacilites() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < checkboxlist.size(); i++) {
			String str = checkboxlist.get(i).getText();
			if (str.contains("Laundry facilities ")) {
				checkboxlist.get(i).click();
				break;
			}
		}
	}
	
	
	public void displayHotelNamesAndPrices() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (hotelnamelist.isEmpty()) {
			System.out.println("No hotels available");
		} else {
			for (int i = 0; i < Math.min(hotelnamelist.size(), 3); i++) {
				String hotelName = hotelnamelist.get(i).getText();
				String hotelPrice = hotelpricelist.get(i).getText();
				System.out.println("Hotel Name : " + hotelName);
				System.out.println("Price : ₹" + hotelPrice);
			}
		}
	}

	
}
