package Tickets;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SafariPopup {
	
	public static final String AUTOMATE_USERNAME = "username";
	public static final String AUTOMATE_ACCESS_KEY = "accesskey";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("osVersion", "14");
		browserstackOptions.put("deviceName", "iPhone 11");
		browserstackOptions.put("realMobile", "true");
		browserstackOptions.put("appiumVersion", "1.22.0");
		browserstackOptions.put("local", "false");
		browserstackOptions.put("buildName", "simBuild");
		browserstackOptions.put("sessionName", "safari-cookies");
		capabilities.setCapability("bstack:options", browserstackOptions);
	    capabilities.setCapability("safariAllowPopups", true);
		    WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
		      driver.get("https://thenextstreet-staging.netfluence.io/student-enrollment-page");
		      Thread.sleep(3000);   
		driver = (RemoteWebDriver) new Augmenter().augment(driver);
		((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//Thread.sleep(2000);

		driver.quit();
		    }

}
