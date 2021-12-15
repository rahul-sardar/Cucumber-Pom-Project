package Parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class AppHooks {

	private DriverFactory driverfactory;
	private PropertiesReader propreader;
	private WebDriver driver;
	Properties prop;
	
	@Before(order =0)
	public void getproperty() {
		propreader = new PropertiesReader();
		prop = propreader.init_prop();
	}
	
	@Before(order =1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browserName);
		
	}
	
	/**
	 * After annotation work in reverse order , meaning order=1 will 
	 * execute first then order =0..like that it goes on.
	 */
	@After(order = 0)
	public void quitBrowser() {
		 driver.quit();
	}
	
	@After(order =1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
	
}
