package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Shein {
	public static ChromeDriver driver;
	public static JavascriptExecutor js;

	
	@Given("open https://www.shein.in/")
	public void open_Browser() throws InterruptedException {
		//open browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//disable notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		options.addArguments("--incognito");
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
	    options.merge(capabilities); 				
	    driver = new ChromeDriver(options);
		//launch url
		driver.get("https://www.shein.in/");
		
		// maximize browser
		driver.manage().window().maximize();

		//implicit wait time
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='c-coupon-box']//i[1]").click();

	}

	@Then("Mouseover on Clothing and click Jeans")
	public void mouseover_clothing_jeans() throws InterruptedException {
		js = (JavascriptExecutor) driver;

		WebElement clothing = driver.findElementByXPath("//span[text()='CLOTHING']");
		Actions builder = new Actions(driver);
		builder.moveToElement(clothing).perform();
		Thread.sleep(1000);
		WebElement jeans = driver.findElementByXPath("(//a[@title='Jeans'])[1]");
		js.executeScript("arguments[0].click()", jeans);

		Thread.sleep(3000);
	}

	@Then("Choose Black under Jeans product count")
	public void choose_Black_Jeans_Product() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		WebElement clrBlack = driver.findElementByXPath("//span[text()='Black']/following-sibling::i");
		js.executeScript("arguments[0].click()", clrBlack);
		Thread.sleep(4000);
	}
	
	@And("check size as medium")
	public void check_Size_Medium() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		WebElement size = driver.findElementByXPath("//li[@class='filter-title leftnav-first-title']//span[text()='Size']");
		js.executeScript("arguments[0].click()", size);
		WebElement medium = driver.findElementByXPath("(//div[@class='attr-group j-attr-group attr-group-size']//a)[4]");
		js.executeScript("arguments[0].click()", medium);
	Thread.sleep(4000);
	}
	
	@Then("check whether the color is black")
	public void check_Color_Black() {
		//String colorBlack = driver.findElementByXPath("//span[text()='Color']/following::div//span[@class='attr-item-pic j-attr-item']//span").getText();
		String blckCrl = driver.findElementByXPath("//a[text()='Black']").getText();
		System.out.println("The color: "+ blckCrl);
	if(blckCrl.equalsIgnoreCase("Black")) {
		System.out.println("The selected color is Black");
	}else {
		System.out.println("The selected color is not Black");
	}
	
	}
	
	@And("Click first item to Add to Bag")
	public void click_First_Item_To_Bag() throws InterruptedException {
		WebElement firstItem = driver.findElementByXPath("(//a[@class='c-goodsitem__goods-name j-goodsitem__goods-name '])[1]");
		Actions builder = new Actions(driver);
		builder.moveToElement(firstItem).perform();
		Thread.sleep(3000);
	}
	@And("Click the size as M and click Submit")
	public void click_Size_M_Click_Submit() throws InterruptedException {
		driver.findElementByXPath("(//button[text()[normalize-space()='+ Add to Bag']])[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[@class='opt-real   '])[3]").click();
		driver.findElementByXPath("(//button[contains(@class,'she-btn-black she-btn-s')])[1]").click();
		
	}
	
	@Then("Click view Bag")
	public void click_View_Bag() throws InterruptedException {
		js = (JavascriptExecutor) driver;

		WebElement bag = driver.findElementByXPath("//i[@class='iconfont-critical icon-gouwudai']");
		js.executeScript("arguments[0].click()", bag);
//		Actions builder1 = new Actions(driver);
//		builder1.moveToElement(bag).perform();
//		Thread.sleep(3000);
//		WebElement viewBag = driver.findElementByXPath("//a[text()='view bag']");
//		builder1.moveToElement(viewBag).click().build().perform();

	//	js.executeScript("arguments[0].click()", viewBag);

		//Thread.sleep(2000);
	}
	
	@And("Check the size is Medium or not")
	public void check_Size_Medium_Not() {
		String size = driver.findElementByXPath("//em[text()='M']").getText();
		System.out.println("The size is: " + size);
		if(size.equalsIgnoreCase("M")) {
			System.out.println("The selected size is M");
		}else {
			System.out.println("The selected size is not M");
		}
	}
	
	@Then("Close browser")
	public void close_Browser() {
		driver.quit();
	}
	
}
