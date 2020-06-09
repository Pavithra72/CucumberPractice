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

public class Trivago {
	public static ChromeDriver driver;
	public static	JavascriptExecutor js; 

	@Given("User launches the Chrome Browser")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
	}
	@And ("Disable the notification")
	public void disableNotification() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		options.addArguments("--incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
			}
	
	@And("Launch https://www.trivago.com/")
	public void loadURL() {
		driver.get("https://www.trivago.com/");
	}
	
	@And("maximise the browser")
	public void maxBrowser() {
		driver.manage().window().maximize();
	}
	
	@And("User set the implicit timeout")
	public void setTimeouts() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	
	@Given("Type Agra in Destination and select Agra, Uttar Pradesh.")
	public void typeAgraInDestinationAndSelectAgraUttarPradesh() throws InterruptedException {
	    driver.findElementByXPath("//input[@id='querytext']").sendKeys("Agra");
	    Thread.sleep(2000);
	    driver.findElementByXPath("//span[text()='City - Uttar Pradesh, India']").click();
			
	}

	@And("Choose June 15 as check in and June 30 as check out")
	public void chooseMayAsCheckInAndJuneAsCheckOut() throws InterruptedException {
		js = (JavascriptExecutor) driver;

		WebElement date15 = driver.findElementByXPath("//time[@datetime='2020-06-15']");
		js.executeScript("arguments[0].click()", date15);

		Thread.sleep(1000);
		WebElement date30 = driver.findElementByXPath("//time[@datetime='2020-06-30']");
		js.executeScript("arguments[0].click()", date30);
		
		Thread.sleep(3000);
		
	   	}
	

	@And("Select Room as Family Room")
	public void selectRoomAsFamilyRoom() {
		js = (JavascriptExecutor) driver;

	WebElement familyRoom = driver.findElementByXPath("//span[text()='Family rooms']"); 
	js.executeScript("arguments[0].click()", familyRoom);

	
	}

	@And("Choose Number of Adults 2, Childern 1 and set Child's Age as 4")
	public void chooseNumberOfAdultsChildernAndSetChildSAgeAs() throws InterruptedException {
		WebElement eleChildren = driver.findElementById("select-num-children-2");
		Select eleNos = new Select(eleChildren);
		eleNos.selectByVisibleText("1");
		Thread.sleep(3000);
   
		WebElement eleChildrenAge = driver.findElementById("select-ages-children-2-3");
		Select eleAge = new Select(eleChildrenAge);
		eleAge.selectByVisibleText("4");
		Thread.sleep(3000);
		
	
	}

	@Then("Click Confirm button and click Search")
	public void clickConfirmButtonAndClickSearch() throws InterruptedException {
		driver.findElementByXPath("//span[text()='Confirm']").click();
		Thread.sleep(6000);

	}

	@And("Select Accommodation type as Hotels only and choose 4 stars")
	public void selectAccommodationTypeAsHotelsOnlyAndChooseStars() throws InterruptedException {
		js = (JavascriptExecutor) driver;

	    WebElement Accommodation = driver.findElementByXPath("//strong[text()='Accommodation']");
	    Actions builder = new Actions(driver);
		builder.moveToElement(Accommodation).perform();
	driver.findElementById("acc-type-filter-1").click();
	Thread.sleep(1000);
	WebElement stars = driver.findElementByXPath("//label[text()='Hotels only']/following::span[text()='4-star hotels']");
	js.executeScript("arguments[0].click()", stars);

	Thread.sleep(1000);
	WebElement done = driver.findElementById("filter-popover-done-button");
	js.executeScript("arguments[0].click()", done);

	Thread.sleep(5000);
	
	
	}

	@And("Select Guest rating as Very Good")
	public void selectGuestRatingAsVeryGood() throws InterruptedException {
		js = (JavascriptExecutor) driver;

	    WebElement guestRating = driver.findElementByXPath("//strong[text()='Guest rating']");
	    Actions builder1 = new Actions(driver);
		builder1.moveToElement(guestRating).perform();
		driver.findElementByXPath("//span[text()='Very good']").click();
//WebElement veryGood = driver.findElementByXPath("//span[text()='Very good']");
//js.executeScript("arguments[0].click()", veryGood);
Thread.sleep(5000);
	
	}

	@And("Set Hotel Location as Agra Fort and click Done")
	public void setHotelLocationAsAgraFortAndClickDone() throws InterruptedException {
		 WebElement hotelLoc = driver.findElementByXPath("//strong[text()='Hotel location']");
		    Actions builder1 = new Actions(driver);
			builder1.moveToElement(hotelLoc).perform();

			WebElement eleSite = driver.findElementById("pois");
			Select site = new Select(eleSite);
			site.selectByVisibleText("Agra Fort");
			Thread.sleep(1000);
			driver.findElementById("filter-popover-done-button").click();
		
		Thread.sleep(5000);
	}

	@Then("In more Filters, select Air conditioning, Restaurant and WiFi and click Done")
	public void inMoreFiltersSelectAirConditioningRestaurantAndWiFiAndClickDone() throws InterruptedException {
		 WebElement moreFilters = driver.findElementByXPath("//strong[text()='More filters']");
		    Actions builder1 = new Actions(driver);
			builder1.moveToElement(moreFilters).perform();
			driver.findElementByXPath("//label[text()='Air conditioning']").click();
			driver.findElementByXPath("//label[text()='WiFi']").click();
			driver.findElementByXPath("//button[text()='Show more']").click();
			driver.findElementByXPath("//label[text()='Restaurant']").click();
			driver.findElementById("filter-popover-done-button").click();
			Thread.sleep(5000);
   
	
	}

	@And("Sort the result as Rating & Recommended")
	public void sortTheResultAsRatingRecommended() throws InterruptedException {
	    WebElement sorting = driver.findElementById("mf-select-sortby");
	    Select selectSort = new Select(sorting);
	    selectSort.selectByVisibleText("Rating & Recommended");
	    Thread.sleep(4000);
	}

	@Then("Print the Hotel name, Rating, Number of Reviews and Click View Deal")
	public void printTheHotelNameRatingNumberOfReviewsAndClickViewDeal() throws InterruptedException {
		System.out.println("The hotel name is: "+ driver.findElementByXPath("(//span[@class='item-link name__copytext'])[1]").getText());
		System.out.println("The Rating of the hotel is: "+ driver.findElementByXPath("(//span[@itemprop='ratingValue'])[1]").getText());
		String review = driver.findElementByXPath("(//span[@class='details-paragraph details-paragraph--rating'])[1]").getText();
	String reviewValue = review.replaceAll("^[0-9]", "");
	System.out.println("The No of Reviews for the hotel is: " + reviewValue);
	
	driver.findElementByXPath("(//span[text()='View Deal'])[1]").click();
	Thread.sleep(5000);
	}

	@Then("Print the URL of the Page")
	public void printTheURLOfThePage() throws InterruptedException {
	Set<String> windowHandles = driver.getWindowHandles();   
	List<String> list = new ArrayList<String>(windowHandles);
	driver.switchTo().window(list.get(1));
	System.out.println("The URL of the page is: " + driver.getCurrentUrl());
	Thread.sleep(1000);
	}

	@Then("Print the Price of the Room and click Choose Your Room")
	public void printThePriceOfTheRoomAndClickChooseYourRoom() throws InterruptedException {
	    String price = driver.findElementByXPath("(//div[contains(@class,'bui-price-display__value prco-text-nowrap-helper')])[1]").getText();
	System.out.println("The Price of the Room is: " + price);
	
	driver.findElementByXPath("(//span[text()[normalize-space()='Choose your room']])[1]").click();
	Thread.sleep(6000);
	
	}

	@Then("Click Reserve and I'll Reserve")
	public void clickReserveAndILlReserve() {
	    driver.findElementByXPath("(//span[@class='bui-button__text'])[1]").click();
	    driver.findElementByXPath("//div[@class='hprt-reservation-cta']").click();
	}

	@And("Close the browser")
	public void closeTheBrowser() {
	    driver.quit();
	}

	
	
	

}
