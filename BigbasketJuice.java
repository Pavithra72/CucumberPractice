package steps;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import hooks.Hooks;

public class BigbasketJuice {
	//public static ChromeDriver driver;
	public static JavascriptExecutor js;
private Hooks hooks;
	
	public BigbasketJuice(Hooks hooks) {
		this.hooks = hooks;
	}
	@Given ("launch https://www.bigbasket.com/")
	public void launch_The_Url() {
				//launch url
		//driver.get("https://www.bigbasket.com/");
	hooks.getDriver().get("https://www.bigbasket.com/");
		}

	@Then ("mouse over to  Shop by Category")
	public void mouse_over_Category() throws InterruptedException {
		WebElement eleCategory = hooks.getDriver().findElementByXPath("//a[text()=' Shop by Category ']");
		Actions builder = new Actions(hooks.getDriver());
		builder.moveToElement(eleCategory).perform();
		Thread.sleep(1000);

			}
	@And("Go to Beverages and Fruit juices & Drinks")
	public void go_to_beverages_juices_and_Drinks() throws InterruptedException {
		WebElement eleBeverage= hooks.getDriver().findElementByXPath("(//a[text()='Beverages'])[2]");
		Actions builder1 = new Actions(hooks.getDriver());
		builder1.moveToElement(eleBeverage).perform();
		Thread.sleep(3000);
		WebElement eleJuice = hooks.getDriver().findElementByXPath("(//a[text()='Fruit Juices & Drinks'])[2]");
		eleJuice.click();
//		Actions builder2 = new Actions(hooks.getDriver());
//		builder2.moveToElement(eleJuice).perform();
		Thread.sleep(3000);

	}
	@And("Click on JUICES")
	public void click_On_Juices() throws InterruptedException {
		hooks.getDriver().findElementByXPath("(//span[text()='Juices'])[1]").click();
		Thread.sleep(2000);
	}
	
	@Then("click Tropicana and Real under Brand")
	public void click_Tropicana_And_Real() throws InterruptedException {
		js = (JavascriptExecutor) hooks.getDriver();

		WebElement brnReal = hooks.getDriver().findElementByXPath("(//span[text()='Real'])[1]");
		js.executeScript("arguments[0].click()", brnReal);
		Thread.sleep(2000);
		WebElement brnTropicana = hooks.getDriver().findElementByXPath("(//span[text()='Tropicana'])[1]");
		js.executeScript("arguments[0].click()", brnTropicana);
		Thread.sleep(2000);
	
	}
	@And("Check count of the products from each Brands and total count")
	public void check_Count_Of_Products_From_Each_Brand_And_Total_Count() {
		int real=0;
		int tropicana=0;
		List<WebElement> productNames = hooks.getDriver().findElementsByXPath("//div[@qa='product_name']//h6");
		System.out.println("Total number of Products are: " + productNames.size() );
for (WebElement eachProd : productNames) {
	
		if(eachProd.getText().equalsIgnoreCase("Real")) {
				real=real+1;
			}else if(eachProd.getText().equalsIgnoreCase("Tropicana")){
				tropicana=tropicana+1;
			}else {
				System.out.println("The given product is not filtered");
			}
		}
		System.out.println("The Real product juices count is: " + real);
		System.out.println("The Tropican product Juices count is: " + tropicana);
		
		int total = real + tropicana;
		if(total== productNames.size()) {
			System.out.println("The Total count matches the brands count");
		}else {
			System.out.println("The Total count didnt matches the brands count");
		}
		System.out.println("*******************************************************");
	}
	@And("Check whether the products is availabe with Add button.")
	public void check_Products_Available_With_Add_Button() {
		List<WebElement> buttons = hooks.getDriver().findElementsByXPath("//button[@class='btn btn-add col-xs-9']");
		int CountOfButtons = buttons.size();
		System.out.println("The count of buttons from all products: " +CountOfButtons);
		int btnCount =0;
		for (WebElement eachBtn : buttons) {
			if(eachBtn.getText().equalsIgnoreCase("ADD")) {
				btnCount=btnCount+1;
			}
		}
		System.out.println("The count of Add buttons is: " + btnCount);
		if(btnCount==CountOfButtons) {
			System.out.println("All the products contains Add button");
		}else {
			System.out.println("All the products dosent contains Add button");
		}
	
		System.out.println("*******************************************************");
	
		
	}
	@Then("Add the First listed available product")
	public void add_First_Avaliable_Product() throws InterruptedException {
		hooks.getDriver().findElementByXPath("(//button[@qa='add'])[1]").click();
		Thread.sleep(1000);
		hooks.getDriver().findElementByXPath("//div[@id='city-drop-overlay']").click();
		Thread.sleep(1000);
	}
		
	@And("click Change Address")
	public void click_Change_Address() throws InterruptedException {
		js = (JavascriptExecutor) hooks.getDriver();

		WebElement address = hooks.getDriver().findElementByXPath("//span[@ng-bind='vm.user.currentAddress.address_display_name']");
		js.executeScript("arguments[0].click()", address);

		Thread.sleep(500);

	}
	@Then("Select Chennai, Alandur as Area  and click Continue")
	public void select_Chennai_Alandur_And_Click_Continue() throws InterruptedException {
		hooks.getDriver().findElementByXPath("//input[@id='areaselect']").sendKeys("Alandur");
		Thread.sleep(1000);
		hooks.getDriver().findElementByXPath("(//strong[text()='Alandur']/parent::a[text()='-600016,Chennai'])[5]").click();
		hooks.getDriver().findElementByXPath("//button[@name='continue']").click();
		Thread.sleep(3000);
		
	}
	
	@And("Mouse over on My Basket print the product name. count and price.")
	public void mouseover_MyBasket_Print_ProductName_Count_Price() throws InterruptedException {
		WebElement basket = hooks.getDriver().findElementByXPath("//span[@class='basket-content']");
		Actions builder = new Actions(hooks.getDriver());
		builder.moveToElement(basket).perform();
		Thread.sleep(3000);
		String prodName = hooks.getDriver().findElementByXPath("//a[@qa='prodNameMB']").getText();
		System.out.println("The product name is: " + prodName);
		String jQuantity = hooks.getDriver().findElementByXPath("(//div[@qa='pcsMB'])[1]").getText();
		String juiceQuantity = jQuantity.substring(0, 1);
		System.out.println("The Quantity of juice is: " + juiceQuantity);
		String juicePrice = hooks.getDriver().findElementByXPath("//span[@qa='priceMB']").getText();
		System.out.println("The price of the Juice Product is: "+juicePrice);
		System.out.println("*******************************************************");

	}
	@And("Click View Basket then Checkout")
	public void click_ViewBasket_Checkout() throws InterruptedException {
		hooks.getDriver().findElementByXPath("//button[text()='View Basket & Checkout']").click();
		Thread.sleep(2000);
		
	}
	@And("Click the close button")
	public void click_Close() {
		hooks.getDriver().findElementByXPath("(//button[@class='close'])[1]").click();

	}
}
