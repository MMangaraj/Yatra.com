package testScenario;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.GiftPage;
import testBase.BaseClass;

public class TC_003_GiftPage extends BaseClass{
	GiftPage GP;
	
	@Test(priority = 1)
	public void ClickonGift() {
		GP = new GiftPage(driver);
		GP.moveToMore();
		logger.info("Pointing to More.");
		GP.selectGiftFromMoreList();
		logger.info("Gift is Selected.");
	}
	@Test(priority = 2,dependsOnMethods= {"ClickonGift"})
	public void filldetails() throws IOException {
		try {
			GP.switchToGiftVoucher(driver);
			logger.info("Redirected to Gift Voucher Page.");
			GP.scrolltocorporte();
			logger.info("Scroll to corporate queries");
			GP.checkForPhoneToolTip();
			logger.info("Phone number is printed.");
			GP.checkForEmailToolTip();
			logger.info("Email is is printed.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
