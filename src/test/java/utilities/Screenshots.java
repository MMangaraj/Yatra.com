package utilities;
import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testBase.BaseClass;
 
public class Screenshots {
	public static String screenShotTC(String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date = new Date();
		String dateValue = dateFormat.format(date);
		String strdestination = System.getProperty("user.dir") + "/Screenshots/" + screenShotName + "_" + dateValue
				+ ".png";
		File destination = new File(strdestination);
		try { // now copy the screenshot to desired location using copyFile method
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return strdestination;
	}
}