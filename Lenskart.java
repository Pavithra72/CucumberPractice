package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.Hooks;

public class Lenskart {
	public static JavascriptExecutor js;

	private Hooks hooks;
		
		public Lenskart(Hooks hooks) {
			this.hooks = hooks;
		}
		
		@Given("Go to https:\\/\\/www.lenskart.com\\/")
		public void go_to_https_www_lenskart_com() throws InterruptedException {
			hooks.getDriver().get("https://www.lenskart.com/");
			Thread.sleep(1000);
		//	hooks.getDriver().findElement(By.id("wzrk-cancel")).click();
		}

		@Then("Mouseover on Contact Lenses")
		public void mouseover_on_Contact_Lenses() throws InterruptedException {
		   WebElement contactLens = hooks.getDriver().findElementByXPath("//a[text()='Contact Lenses']");
		   Actions builder = new Actions(hooks.getDriver());
		   builder.moveToElement(contactLens).perform();
		   Thread.sleep(1000);
		}

		@Then("Click on Monthly under Explore By Disposability")
		public void click_on_Monthly_under_Explore_By_Disposability() throws InterruptedException {
			hooks.getDriver().findElement(By.xpath("//span[text()='Monthly']")).click();
			Thread.sleep(5000);
		}

		@Then("Select brand as Aqualens")
		public void select_brand_as_Aqualens() throws InterruptedException {
		   hooks.getDriver().findElementByXPath("(//span[contains(text(),'Aqualens')])[2]").click();
		   Thread.sleep(3000);
		}

		@Then("Click on the first product")
		public void click_on_the_first_product() throws InterruptedException {
		   hooks.getDriver().findElementByXPath("(//div[@class='col-md-12 no-padding']//div)[1]").click();
		   Thread.sleep(7000);
		}

		@Then("Click Buy Now")
		public void click_Buy_Now() throws InterruptedException {
			js = (JavascriptExecutor) hooks.getDriver();

			WebElement buyNow = hooks.getDriver().findElement(By.xpath("//button[text()='BUY NOW']"));
			js.executeScript("arguments[0].click()", buyNow);
	
			Thread.sleep(3000);
		}

		@Then("Select No of boxes as 2 and Power as -1 for both eyes")
		public void select_No_of_boxes_as_and_Power_as_for_both_eyes() throws InterruptedException {
			js = (JavascriptExecutor) hooks.getDriver();

		   WebElement odBox = hooks.getDriver().findElementByXPath("(//select[@name='boxes'])[1]");	
		   Select sltODbox = new Select(odBox);
		   sltODbox.selectByVisibleText(" 2 Box");
		   WebElement osBox = hooks.getDriver().findElementByXPath("(//select[@name='boxes'])[2]");	
		   Select sltOSbox = new Select(osBox);
		   sltOSbox.selectByVisibleText("2 Box");
		  
		   
		   WebElement odPower = hooks.getDriver().findElementByXPath("(//i[contains(@class,'fa fa-chevron-down')])[1]");
			js.executeScript("arguments[0].click()", odPower);

		   WebElement odPwr = hooks.getDriver().findElement(By.xpath("//div[text()='-1.00']"));
			js.executeScript("arguments[0].click()", odPwr);
			Thread.sleep(500);
//			WebElement boxes = hooks.getDriver().findElement(By.xpath("(//select[@name='boxes'])[2]")); 
//			new Select(boxes).selectByValue("2 Box"); 
			
		  
		   
		   WebElement osPower = hooks.getDriver().findElement(By.xpath("(//i[contains(@class,'fa fa-chevron-down')])[2]"));
			js.executeScript("arguments[0].click()", osPower);

		   WebElement osPwr = hooks.getDriver().findElement(By.xpath("//div[text()='-1.00']"));
			js.executeScript("arguments[0].click()", osPwr);

		   Thread.sleep(1000);
		}

		@Then("Type your name in User's name")
		public void type_your_name_in_User_s_name() {
			hooks.getDriver().findElement(By.id("example-text-input")).sendKeys("Pavithra");
		}

		@Then("And click Save and continue")
		public void and_click_Save_and_continue() throws InterruptedException {
			   hooks.getDriver().findElement(By.xpath("(//button[@type='submit'])[2]")).click();
			   Thread.sleep(3000);

		}

		@Then("Print total amount and click Proceed to Checkout")
		public void print_total_amount_and_click_Proceed_to_Checkout() {
			String orderTotal = hooks.getDriver().findElement(By.xpath("//span[contains(@class,'span6 color-yellow')]")).getText();
			
			System.out.println("The total order price is: "+orderTotal);
			hooks.getDriver().findElement(By.xpath("//span[text()='Proceed To Checkout']")).click();
			
		}



}
