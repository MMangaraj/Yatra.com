package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CruisePage extends BasePage {
	WebDriver driver;
	Actions action;
	JavascriptExecutor js;
	public CruisePage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	@FindBy(xpath = "//span[@class='more-arr']")
	WebElement more;
	
	@FindBy(xpath = "//div[@class='moreOption']//li")
	List<WebElement> morelist;
	
	@FindBy(xpath = "(//i[@class='demo-icon icon-go arrow-go'])[1]")
	WebElement readmore;

	@FindBy(xpath = "(//li[@class='block-desc']//span)[1]")
	WebElement inclusionpoints;
	
	public void moveToMore() {
		action.moveToElement(more).perform();
	}
	
	public void selectCruiseFromMoreList() {
		for (int i = 0; i < morelist.size(); i++) {
			String morelisttxt = morelist.get(i).getText();
			
			if (morelisttxt.contains("Cruise")) {
				action.moveToElement(morelist.get(i)).click().perform();
			}
		}
	}
	
	public void clickonReadMore() {
		readmore.click();
	}

	public void printInclusionPoints() {
		js.executeScript("window.scrollBy(0,250)", "");
		System.out.println(inclusionpoints.getText());
	}
	
	
	
	
	
}
