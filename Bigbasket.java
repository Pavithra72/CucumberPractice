package steps;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Bigbasket {
	public static ChromeDriver driver;
	public static JavascriptExecutor js;

	@Given ("Go to https://www.bigbasket.com/")
	public void launch_The_Url() {
		//open browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//disable notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		options.addArguments("--incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		//launch url
		driver.get("https://www.bigbasket.com/");
		
		// maximize browser
		driver.manage().window().maximize();

		//implicit wait time
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then ("mouse over on Shop by Category")
	public void mouse_over_Category() throws InterruptedException {
		WebElement eleCategory = driver.findElementByXPath("//a[text()=' Shop by Category ']");
		Actions builder = new Actions(driver);
		builder.moveToElement(eleCategory).perform();
		Thread.sleep(1000);

			}
	@Then("Go to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS")
	public void go_To_Rice_Products() throws InterruptedException {
		WebElement elefood = driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(elefood).perform();
		Thread.sleep(3000);
		WebElement elerice = driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]");
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(elerice).perform();
		Thread.sleep(3000);

	}
	
	@And("Click on BOILED & STEAM RICE")
	public void click_Boiled_Steam_Rice() throws InterruptedException {
		driver.findElementByXPath("(//a[text()='Boiled & Steam Rice'])[2]").click();
		Thread.sleep(6000);

	}
	@Then("Get the URL of the page and check eith with site navigation link\\(HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)")
	public void get_the_URL_of_the_page_and_check_eith_with_site_navigation_link_HOME_FOODGRAINS_OIL_MASALA_RICE_RICE_PRODUCTS_BOILED_STEAM_RICE() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The Url of the page is: "+ currentUrl);
		String navigation = driver.findElementByXPath("//div[@class='breadcrumb']").getText();
		System.out.println("The Navigation is: " + navigation);
		String naviUrl="HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE";
		if(navigation.equalsIgnoreCase(naviUrl)) {
			System.out.println("The Navigation Url is correct");
		}else {
			System.out.println("The Navigation Url is not correct");
		}
	}
	
	@Then("Choose the Brand as bb Royal")
	public void choose_Brand_bb_Royal() throws InterruptedException {
		driver.findElementByXPath("(//span[text()='bb Royal'])[1]").click();
		Thread.sleep(5000);

	}
	
	@And("Go to Ponni Boiled Rice and select 10kg bag from Dropdown")
	public void go_To_Ponni_Boiled_Rice_Select_Kg_Bag_Dropdown() {
		driver.findElementByXPath("(//a[text()='Ponni Boiled Rice/Puzhungal Arisi']/following::div[@class='btn-group btn-input clearfix ng-scope'])[1]").click();
		driver.findElementByXPath("(//a[text()='Ponni Boiled Rice/Puzhungal Arisi']/following::span[contains(text(),'10 kg')])[1]").click();

	}
	
	@And("Click Add button")
	public void click_Add_Button() throws InterruptedException {
		driver.findElementByXPath("(//a[text()='Ponni Boiled Rice/Puzhungal Arisi']/following::button[@qa='add'])[1]").click();
		Thread.sleep(2000);
	}

	@Then("Go to search box and type Dal")
	public void go_To_Search_Box_Type_Dal() throws InterruptedException {
		driver.findElementByXPath("//input[@id='input']").sendKeys("DAL", Keys.ENTER);
		Thread.sleep(3000);

	}
	@Then("Add Toor\\/Arhar Dal two kg and set Qty two from the list")
	public void add_Toor_Arhar_Dal_two_kg_and_set_Qty_two_from_the_list() throws InterruptedException {
		driver.findElementByXPath(
				"(//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']/following::div[@class='btn-group btn-input clearfix ng-scope'])[1]")
				.click();
		driver.findElementByXPath(
				"(//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']/following::span[contains(text(),'2 kg')])[1]").click();
		WebElement quantity = driver
				.findElementByXPath("(//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']/following::input)[1]");
		quantity.clear();
		quantity.sendKeys("2");
		driver.findElementByXPath("(//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']/following::button[@qa='add'])[1]")
		.click();
Thread.sleep(2000);

	}
	
	@Then("click Address")
	public void click_Address() throws InterruptedException {
		js = (JavascriptExecutor) driver;

		WebElement address = driver.findElementByXPath("//span[@ng-bind='vm.user.currentAddress.address_display_name']");
		js.executeScript("arguments[0].click()", address);

		Thread.sleep(500);
	}
	
	@And("Select Chennai as City, Alandur as Area and click Continue")
	public void select_Chennai_as_City_Alandur_As_Area_And_Click_Continue() throws InterruptedException {
		driver.findElementByXPath("//input[@id='areaselect']").sendKeys("Alandur");
		Thread.sleep(1000);
		driver.findElementByXPath("(//strong[text()='Alandur']/parent::a[text()='-600016,Chennai'])[5]").click();
		driver.findElementByXPath("//button[@name='continue']").click();
		Thread.sleep(3000);
		
	}
	@Then("Mouse over on My Basket take a screen shot")
	public void mouse_Over_on_my_basket_take_A_Screen_Shot() throws InterruptedException, IOException {
		WebElement basket = driver.findElementByXPath("//span[@class='basket-content']");
		Actions builder = new Actions(driver);
		builder.moveToElement(basket).perform();
		Thread.sleep(1000);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/snap1.png");
		FileUtils.copyFile(src, dst);
	}
	
	@Then("Click View Basket and Checkout")
	public void click_View_Basket_And_Checkout() throws InterruptedException {
		driver.findElementByXPath("//button[text()='View Basket & Checkout']").click();
		Thread.sleep(2000);
	}
	@And("Click the close button and close the browser")
	public void click_the_Close_Button_Close_Browser() {
		driver.findElementByXPath("(//button[@class='close'])[1]").click();
		driver.quit();
	}
	
}
