package pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class GiftPage extends BasePage {
	WebDriver driver;
	Actions action;
	JavascriptExecutor js;
	ExcelUtility excelutility;
	public GiftPage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
		js  = (JavascriptExecutor) driver;
		excelutility = new ExcelUtility();
		
	}
	@FindBy(xpath = "//span[@class='more-arr']")
	WebElement more;
	@FindBy(xpath = "//div[@class=\"frmDiv\"]")
	WebElement scrolltoform;
	
	@FindBy(xpath = "//div[@class='moreOption']//li")
	List<WebElement> morelist;
	
	@FindBy(id = "Name")
	WebElement name;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;

	public void moveToMore() {
		action.moveToElement(more).perform();
	}
	
	public void selectGiftFromMoreList() {
		for (int i = 0; i < morelist.size(); i++) {
			String morelisttxt = morelist.get(i).getText();
			if (morelisttxt.contains("Gift")) {
				action.moveToElement(morelist.get(i)).click().perform();
			}
		}
	}
	
	public void switchToGiftVoucher(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows)
			driver.switchTo().window(window);
	}
	
	public void scrolltocorporte() {
		js.executeScript("arguments[0].scrollIntoView();",scrolltoform);
		
	}
	
	public void checkForPhoneToolTip() throws InterruptedException, IOException {
		
		action.moveToElement(phone).build().perform();

		name.sendKeys(excelutility.getCellData("Sheet1", 1, 0));
		phone.sendKeys(excelutility.getCellData("Sheet1", 1, 1));
		js.executeScript("arguments[0].click();", submit);
//		submit.click();
		Thread.sleep(1000);
		String phoneerr = phone.getAttribute("data-errormsg");
		System.out.println("Phone number error message : " + phoneerr);

	}

	public void checkForEmailToolTip() throws InterruptedException, IOException {
		action.moveToElement(phone).build().perform();
		name.clear();
		name.sendKeys(excelutility.getCellData("Sheet1", 2, 0));
		phone.clear();
		phone.sendKeys(excelutility.getCellData("Sheet1", 2, 1));
		email.clear();
		email.sendKeys(excelutility.getCellData("Sheet1", 2, 2));
		js.executeScript("arguments[0].click();", submit);
//		submit.click();
		Thread.sleep(1000);
		String capturetooltip = email.getAttribute("data-errormsg");
		System.out.println("Email error message : " + capturetooltip);

	}
	
	
	
}
