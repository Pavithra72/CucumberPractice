package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Ajio {
	public static ChromeDriver driver;
	public static JavascriptExecutor js;

	@Given("launch the Chrome Browser")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

	}

	@And("Disable notification")
	public void disableNotification() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		options.addArguments("--incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
	}

	@And("launch the url https:\\\\/\\\\/www.ajio.com\\\\/shop\\\\/women")
	public void launch_the_url_https_www_ajio_com_shop_women() {
		driver.get("https://www.ajio.com/shop/women");
	}

	@And("maximise browser")
	public void maxBrowser() {
		driver.manage().window().maximize();
	}

	@And("set the implicit timeout")
	public void setTimeouts() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("Mouseover on Women, CATEGORIES and click on Kurtas")
	public void mouseover_on_Women_CATEGORIES_and_click_on_Kurtas() {
		WebElement women = driver.findElementByXPath("(//a[text()='WOMEN'])[1]");
		Actions builder = new Actions(driver);
		builder.moveToElement(women).perform();
		driver.findElementByXPath("(//a[text()='Kurtas'])[2]").click();
	}

	@And("Click on Brands and choose Ajio")
	public void click_on_Brands_and_choose_Ajio() {
		driver.findElementByXPath("//span[text()='brands']").click();
		driver.findElementByXPath("//label[@for='AJIO']").click();

	}

	@Then("Check all the results are Ajio")
	public void check_all_the_results_are_Ajio() {
		int brandsize = 0;
		List<WebElement> brands = driver.findElementsByXPath("//div[@class='brand']");
		for (WebElement eachEle : brands) {
			if (eachEle.getText().equalsIgnoreCase("AJIO")) {
				brandsize = brandsize + 1;
			}

		}
		if (brandsize == brands.size()) {
			System.out.println("All the brands are Ajio");
		} else {
			System.out.println("All the brands are not Ajio");
		}

	}

	@Then("Set Sort by the result as Discount")
	public void set_Sort_by_the_result_as_Discount() {
		WebElement sorting = driver.findElementByXPath("//div[@class='filter-dropdown']//select");
		Select slSort = new Select(sorting);
		slSort.selectByVisibleText("Discount");

	}

	@And("Select the first product")
	public void select_the_first_product() throws InterruptedException {
		driver.findElementByXPath("(//div[@class='name'])[1]").click();
		Thread.sleep(2000);
	}

	@And("Select the Color and click ADD TO BAG")
	public void select_the_Color_and_click_ADD_TO_BAG() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ls.get(1));

		driver.findElementByXPath("//img[@title='blue']").click();
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		Thread.sleep(2000);

	}

	@Then("Verify the error message Select your size to know your estimated delivery date")
	public void verify_the_error_message_Select_your_size_to_know_your_estimated_delivery_date() {
		String errMsg = driver.findElementByXPath("(//div[@class='err-msg-blk']//span)[5]").getText();
		if (errMsg.equalsIgnoreCase("Please select a size")) {
			System.out.println("The error message displayed is " + errMsg + " and it is verified");
		}
	}

	@Then("Select size and click ADD TO BAG")
	public void select_size_and_click_ADD_TO_BAG() throws InterruptedException {
		driver.findElementByXPath("(//div[@class='circle size-variant-item size-instock '])[1]").click();
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		Thread.sleep(4000);

	}

	@Then("click on Enter pin-code to know estimated delivery date")
	public void click_on_Enter_pin_code_to_know_estimated_delivery_date() {
		driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']").click();
	}

	@And("Enter the pincode as 603103 and click Confirm pincode")
	public void enter_the_pincode_as_and_click_Confirm_pincode() throws InterruptedException {
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("603103");
		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();
		Thread.sleep(3000);

	}

	@And("Print the message and click Go to  Bag")
	public void print_the_message_and_click_Go_to_Bag() throws InterruptedException {
		String msg = driver.findElementByXPath("(//ul[@class='edd-message-success-details']//li)[1]").getText();
		System.out.println("The message after entering pincode is: "+msg);
		
		driver.findElementByXPath("//span[text()='GO TO BAG']").click();
		Thread.sleep(3000);
		}

	@Then("Click on Proceed to Shipping and close the browser")
	public void click_on_Proceed_to_Shipping_and_clode_the_browser() {
		driver.findElementByXPath("//button[text()='Proceed to shipping']").click();
		driver.quit();
	}

}
