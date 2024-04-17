package stepDefinition;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	public static WebDriver driver;
	public static Logger logger;
	public Properties p;
	public String br;

	
    @Before	
	public void setup() throws IOException{
		
		//Loading Properties File
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		//Loading log4j file
		
		logger = LogManager.getLogger(this.getClass());
		br=p.getProperty("browser");
		//Grid
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			DesiredCapabilities capabilites = new DesiredCapabilities();
			switch(br.toLowerCase()) {
			case "chrome" : capabilites.setBrowserName("chrome"); break;
			case "edge" : capabilites.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matchingg broswer...");
			
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilites);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		if (br.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}
		if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			Map<String, Object> prefs = new LinkedHashMap<>();
			prefs.put("user_experience_metrics.personalization_data_consent_enabled", Boolean.valueOf(true));
			options.setExperimentalOption("prefs", prefs);
			driver = new EdgeDriver(options);
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
	}
	
	public static Logger getLogger() {
		logger = LogManager.getLogger();
		return logger;
	}
    @After
	public void tearDown() {
		driver.quit();
	}
	
    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        }
        else {
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	
        }
    }
}

