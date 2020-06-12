package steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
import cucumber.api.java.en.When;

public class Shopclues {
	
	public static ChromeDriver driver;
	public static JavascriptExecutor js;
	List<WebElement> allProdName;
	List<WebElement> allProdPrice;
	Map<String, String> mapProds;
	public static String prodName = "";
	public static String prodPrice ="";

	
	@Given("Go to https://www.shopclues.com/")
	public void launch_Url() throws InterruptedException {
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
				driver.get("https://www.shopclues.com/");
				
				// maximize browser
				driver.manage().window().maximize();

				//implicit wait time
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(2000);
				
				driver.findElementByXPath("//button[text()='Allow']").click();
				Thread.sleep(4000);


	}
	
	@Then("Mouseover on women and click Casual Shoes")
	public void mouseover_Women_click_Casual_Shoes() throws InterruptedException {
		WebElement women_Mouseover = driver.findElementByXPath("//a[text()='WOMEN']");
		Actions builder = new Actions(driver);
		builder.moveToElement(women_Mouseover).perform();
		Thread.sleep(1000);
		driver.findElementByXPath("(//a[text()='Casual Shoes'])[1]").click();
		Thread.sleep(3000);
	}
	
	@And("Select Color as Black")
	public void select_Color_As_Black() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		js = (JavascriptExecutor) driver;

		WebElement clrBlack = driver.findElementByXPath("//label[@for='Black']");
		js.executeScript("arguments[0].click()", clrBlack);
		Thread.sleep(3000);

	}
	
	@When("Check whether the product name contains the word black")
	public void check_Product_Name_Contains_Black() {
		allProdName = driver.findElementsByXPath("//span[@class='prod_name ']");
		allProdPrice = driver.findElementsByXPath("//span[@class='p_price']");
		
	}
	
	@Then("If so, add the product name and price in to Map")
	public void if_So_Add_Product() {
		mapProds = new LinkedHashMap<String, String>();
		for(int i=1;i<=allProdName.size();i++) {
			String namexpath = "(//span[@class = 'prod_name '])[" +i+  "]";
			String name = driver.findElementByXPath(namexpath).getText();
if(name.toLowerCase().contains("black")){
	String pricexpath = namexpath + "/following-sibling::div[1]/div[1]/span[1]";
	String price = driver.findElementByXPath(pricexpath).getText();
	String  priceamt = price.replaceAll("[^0-9]", "");
	mapProds.put(name,priceamt);

//				for (WebElement eachProdName : allProdName) {
//			if(eachProdName.getText().toLowerCase().contains("black")) {
//				prodName=eachProdName.getText();
//				for (WebElement eachProdPrice : allProdPrice) {
//					prodPrice=eachProdPrice.getText();
//				}
				//mapProds.put(prodName, prodPrice);
		
			}
			
		}
		
		for (Entry<String, String> eachMapProds : mapProds.entrySet()) {
			System.out.println(eachMapProds.getKey()+"--->"+eachMapProds.getValue());
			
		}
	}
	
	@When("Check Display the count of shoes which are more than 500 rupees")
	public void check_Display_Count_Shoes_More_Rupees() {
		int price =0;
		for (WebElement eachProdPrice : allProdPrice) {
			String priceProd = eachProdPrice.getText();
			int priceno = Integer.parseInt(priceProd.replaceAll("\\D", ""));
			if(priceno>500) {
				price=price+1;
			}
		}
		System.out.println("The count of shoes which are more than 500 rupees are: " + price );
	}
	
	@Then("Click the highest price of the shoe")
	public void click_Highest_Price_Of_Shoe() throws InterruptedException {	
		js = (JavascriptExecutor) driver;

		WebElement highPrice = driver.findElementByXPath("//a[text()='High Price']");
		js.executeScript("arguments[0].click()", highPrice);

		Thread.sleep(2000);
		driver.findElementByXPath("(//span[@class='prod_name '])[1]").click();
		Thread.sleep(1000);
	}
	
	@And("Get the current page URL and check with the product ID")
	public void get_Url_Check_Product_ID() {
		Set<String> winSet = driver.getWindowHandles(); 
	    List<String> winList = new ArrayList<String>(winSet); 
	    int size = winList.size(); 
	    driver.switchTo().window(winList.get(size-1));
	    
	    String currentUrl = driver.getCurrentUrl();
	    String repUrl = currentUrl.replaceAll("//D", "");
	    String prodId = driver.findElementByXPath("//span[@class = 'pID']/following-sibling::meta").getAttribute("content");
	  //  String repProdId = prodId.replaceAll("//D", "");
//	    System.out.println("************************");
//	    System.out.println("url"+currentUrl);
//	    System.out.println(repUrl);
//	    System.out.println("prod id" + prodId);
//	    System.out.println("************************");
	    if(currentUrl.contains(prodId)) {
	    	System.out.println("The current url contains the Product id");
	    }else {
	    	System.out.println("The current url didnt contains Product id");
	    }
	}
	
	@And("Copy the offercode")
	public void copy_The_Offercode() {
		String offerCode = driver.findElementByXPath("(//div[@class='coupons_code'])[1]").getText();
		System.out.println("The offer code is: "+ offerCode);
	}
	
	@Then("Select size, color and click ADD TO CART")
	public void select_Size_Color_Add_To_Cart() throws InterruptedException {
		driver.findElementByXPath("//span[@class='variant var ']//span").click();
		driver.findElementByXPath("//span[@value='37 (EUR)']").click();
		driver.findElementById("add_cart").click();
		Thread.sleep(3000);
	}
	
	@Then("Mouse over on Shopping cart and click View Cart")
	public void mouseover_ShppingCart_View_Cart() throws InterruptedException {
		WebElement cart = driver.findElementByXPath("//a[@class='cart_ic']");
		Actions builder = new Actions(driver);
		builder.moveToElement(cart).perform();
		Thread.sleep(1000);
		driver.findElementByXPath("//a[text()='View Cart']").click();
		Thread.sleep(3000);
	}
	
	@And("Type Pincode as 600016 click Submit and Place Order")
	public void type_Pincode_Submit_Order() throws InterruptedException {
		driver.findElementById("pin_code_popup").sendKeys("600016");
		driver.findElementById("get_pincode_popup").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[text()='Place Order']").click();
		
	}
	@And("Close the Browser")
	public void close_Browser() {
		driver.quit();
	}

	

}
