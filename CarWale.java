package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CarWale {
	public static ChromeDriver driver;
public static	JavascriptExecutor js; 
public static int lowKmSize;
public static List<Integer> kmsList = new ArrayList<Integer> ();
public static List<Integer> sortKm = new ArrayList<Integer>();


//	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Given("User opens the Chrome Browser")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
	}
	@And ("Disable the notifications")
	public void disableNotification() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		options.addArguments("--incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
			}
	
	@And("Launch https://www.carwale.com/")
	public void loadURL() {
		driver.get("https://www.carwale.com/");
	}
	
	@And("User maximise the browser")
	public void maxBrowser() {
		driver.manage().window().maximize();
	}
	
	@And("User set the default implicit timeout")
	public void setTimeouts() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Given("click on Used")
	public void click_on_Used() {	
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
	   	}

	@And("Select the City as Chennai")
	public void select_the_City_as_Chennai() {
		driver.findElementByXPath("//input[@id='usedCarsList']").sendKeys("Chennai");
		driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();

	   	}

	@And("Select budget min 8L and max 12L and click Search")
	public void select_budget_min_8_and_max_12_and_click_Search() throws InterruptedException {
		driver.findElementByXPath("//li[text()='8 Lakh']").click();
		driver.findElementByXPath("(//li[text()='12 Lakh'])[2]").click();
		driver.findElementByXPath("(//span[@class='welcome-box__search-icon'])[2]").click();
		Thread.sleep(2000);

	    	}

	@And("Select Cars with Photos under Only Show Cars With")
	public void select_Cars_with_Photos_under_Only_Show_Cars_With() throws InterruptedException {
		driver.findElementByXPath("//span[text()='Cars with Photos']").click();
		Thread.sleep(3000);

	    	}

	@And("Select Manufacturer as Hyundai --> Creta")
	public void select_Manufacturer_as_Hyndai_Creta() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		WebElement slcHyundai = driver.findElementByXPath("(//li[@data-manufacture-en='Hyundai']//span)[1]");
		js.executeScript("arguments[0].click()", slcHyundai);
		// wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Creta']")));
		WebElement slcCreta = driver.findElementByXPath("//span[text()='Creta']");
		js.executeScript("arguments[0].click()", slcCreta);
		Thread.sleep(3000);

		
	   	}

	@And("Select Fuel Type as Petrol")
	public void select_Fuel_Type_as_Petrol() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		WebElement eleFuelType = driver.findElementByXPath("//h3[contains(text(),'Fuel Type')]");
		js.executeScript("arguments[0].click()", eleFuelType);
		WebElement elePetrol = driver.findElementByXPath("//li[contains(@name,'Petrol')]");
		js.executeScript("arguments[0].click()", elePetrol);
		Thread.sleep(3000);

	}

	@And("Select Best Match as KM: Low to High")
	public void select_Best_Match() throws InterruptedException {
		WebElement eleBestMatch = driver.findElementById("sort");
		Select eleprice = new Select(eleBestMatch);
		eleprice.selectByVisibleText("KM: Low to High");
		Thread.sleep(3000);

	}

	@Then("Validate the Cars are listed with KMs Low to High")
	public void validate_the_Cars_are_listed_with_KMs_Low_to_High() {
	    String kms ="";
	    List<WebElement> eleKmsLow = driver.findElementsByXPath("//span[@class=\"slkms vehicle-data__item\"]");
	     lowKmSize = eleKmsLow.size();
	    for(int i=0;i<lowKmSize;i++) {
	    	kms = eleKmsLow.get(i).getText();
	    	String reKms = kms.replaceAll("[^0-9]", "");
			int onlyKmsNos = Integer.parseInt(reKms);
			kmsList.add(onlyKmsNos);
	    }

	    sortKm.addAll(kmsList);
	Collections.sort(sortKm);
	if(kmsList.equals(sortKm)) {
		System.out.println("The cars are listed with KMs Low to High");
	}else {
			System.out.println("The cars are not listed  with Kms Low to High");
		}
	}
	

	@And("Add the least KM ran car to Wishlist")
	public void add_the_least_KM_ran_car_to_Wishlist() throws InterruptedException   {
		js = (JavascriptExecutor) driver;

		for (int j = 0; j < lowKmSize; j++) {
			if (kmsList.get(j).equals(sortKm.get(0))) {
				WebElement addToCart = driver
						.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[" + (j + 1) + "]");
				js.executeScript("arguments[0].click()", addToCart);
				Thread.sleep(2000);
				break;
			}
		}
	}

	@And("Go to Wishlist and click on More Details")
	public void go_to_Wishlist_and_click_on_More_Details() throws InterruptedException {
		js = (JavascriptExecutor) driver;

		WebElement wishList = driver.findElementByXPath("//li[@data-action='ShortList&CompareWindow_Click']");
		js.executeScript("arguments[0].click()", wishList);

		WebElement moreDetails = driver.findElementByXPath("//a[contains(text(),'More details')]");
		js.executeScript("arguments[0].click()", moreDetails);

		Thread.sleep(3000);
	}

	@Then("Print all the details under Overview in the same way as displayed in application")
	public void print_all_the_details_under_Overview_in_the_same_way_as_displayed_in_application() {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allList = new ArrayList<String>(allWindows);
		driver.switchTo().window(allList.get(1));
		Map<String, String> details = new LinkedHashMap<String, String>();
		List<WebElement> overview = driver
				.findElementsByXPath("//div[@id='overview']//div[@class='equal-width text-light-grey']");
		List<WebElement> features = driver
				.findElementsByXPath("//div[@id='overview']//div[@class='equal-width dark-text']");
		int detailsSize = overview.size();
		for (int k = 0; k < detailsSize; k++) {
			String mapOverview = overview.get(k).getText();
			String mapFeatures = features.get(k).getText();
			details.put(mapOverview, mapFeatures);
		}

		for (Entry<String, String> each : details.entrySet()) {
			System.out.println(each.getKey() + " ---------- " + each.getValue());

		}

	}

	@And("Close the browser.")
	public void close_the_browser() {
	   driver.quit();
	   }

	}


