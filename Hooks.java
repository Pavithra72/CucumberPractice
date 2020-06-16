package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
 
	private ChromeDriver driver;
	@Before
	public void setUp() {
		//open browser
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				//disable notification
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();

				options.addArguments("--incognito");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);
							
				// maximize browser
				driver.manage().window().maximize();

				//implicit wait time
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}
	public ChromeDriver getDriver() {
		return driver;
	}
	
	@After
	public void endCase() {
		driver.quit();
	}
}
