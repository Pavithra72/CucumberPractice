package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.Hooks;

public class JustDial {
	public static JavascriptExecutor js;
	public static String total;
	public static  int intTotal;
	public static String totalAmt;
	public static int intTotalAmt;
	private Hooks hooks;
		
		public JustDial(Hooks hooks) {
			this.hooks = hooks;
		}
	
	
	@Given("Go to https:\\/\\/www.justdial.com\\/")
	public void go_to_https_www_justdial_com() {
		hooks.getDriver().get("https://www.justdial.com/");
	}

	@Then("Click on Air Tickets")
	public void click_on_Air_Tickets() {
		hooks.getDriver().findElementByXPath("(//span[@class='hotkeys-text'])[5]").click();
	}

	@Then("Type Chennai and choose Chennai, IN - Chennai Airport \\(MAA) as Leaving From")
	public void type_Chennai_and_choose_Chennai_IN_Chennai_Airport_MAA_as_Leaving_From() {
		hooks.getDriver().findElement(By.id("departure")).sendKeys("Chennai");
		hooks.getDriver().findElement(By.xpath("//li[text()='Chennai, IN - Chennai Airport (MAA)']")).click();
	}

	@Then("Type Toronto and select Toronto, CA - Toronto City Centre Airport \\(YTZ) as Going To")
	public void type_Toronto_and_select_Toronto_CA_Toronto_City_Centre_Airport_YTZ_as_Going_To() {
		hooks.getDriver().findElement(By.id("arrival")).sendKeys("Toronto");
		hooks.getDriver().findElement(By.xpath("//li[text()='Toronto, CA - Toronto City Centre Airport (YTZ)']")).click();
	
	}

	@Then("Set Departure as 2020, July 22")
	public void set_Departure_as_July() throws InterruptedException {
		hooks.getDriver().findElement(By.xpath("//span[text()='Next']")).click();
		hooks.getDriver().findElement(By.linkText("22")).click();
		Thread.sleep(1000);
	}

	@Then("Add Adult 2, Children 1 click and Search")
	public void add_Adult_Children_click_and_Search() throws InterruptedException {
		hooks.getDriver().findElement(By.xpath("(//span[text()='+'])[1]")).click();
		hooks.getDriver().findElement(By.xpath("(//span[text()='+'])[2]")).click();
		hooks.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
	}

	@Then("Select Air Canada from multi-airline itineraries")
	public void select_Air_Canada_from_multi_airline_itineraries() throws InterruptedException {
		hooks.getDriver().findElement(By.xpath("(//input[@name='operating_airline'])[1]")).click();
		Thread.sleep(1000);
		}

	@Then("Click on Price to sort the result")
	public void click_on_Price_to_sort_the_result() {
		hooks.getDriver().findElement(By.id("priceSort")).click();
	}

	@Then("Click on +Details of first result under Price")
	public void click_on_Details_of_first_result_under_Price() {
		hooks.getDriver().findElement(By.xpath("(//tr[@class='resTextAlign2']//a)[1]")).click();
	}

	@Then("Capture the Flight Arrival times.")
	public void capture_the_Flight_Arrival_times() {
	   List<WebElement> arrivalTimes = hooks.getDriver().findElementsByXPath("//table[@class = 'detTab']/tbody/tr/td[6]");
		System.out.println("The Arrival Timings are: ");

	   for (WebElement eachEle : arrivalTimes) {
		System.out.println(eachEle.getText());
	}
	   
	}

	@Then("Capture the total price in a list and Click on Book")
	public void capture_the_total_price_in_a_list_and_Click_on_Book() throws InterruptedException {
		total  = hooks.getDriver().findElement(By.xpath("//div[@id='resDet1']/div[2]/ul[1]/li[4]/div[1]/span[1]")).getText();
		 intTotal = Integer.parseInt(total);
		System.out.println("The Total price in list is: " + total);
		hooks.getDriver().findElement(By.xpath("(//a[@class='bookButton'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("Capture the Airport name base on the list of time")
	public void capture_the_Airport_name_base_on_the_list_of_time() {
		//span[@class='dettime']
		List<WebElement> airportsDepature = hooks.getDriver().findElementsByXPath("//span[@class='dettime']//following::tr[@class='childText']/td[2]");
		List<WebElement> airportsArrival = hooks.getDriver().findElementsByXPath("//span[@class='dettime']//following::tr[@class='childText']/td[4]");
System.out.println("The Airports name on depature: ");
System.out.println("*********************************");
for (WebElement eachEle : airportsDepature) {
	System.out.println(eachEle.getText());
}
System.out.println("*********************************");
System.out.println("The Airports name on depature: ");
System.out.println("*********************************");
	for (WebElement eachEle1 : airportsArrival) {
		System.out.println(eachEle1.getText());

		
	}
	}

	@Then("Capture the total fare and print the difference amount from previous total price")
	public void capture_the_total_fare_and_print_the_difference_amount_from_previous_total_price() {
		  totalAmt = hooks.getDriver().findElement(By.xpath("//span[@id='totalFare']//b[1]")).getText();
		   intTotalAmt = Integer.parseInt(totalAmt);
		   int diffAmt = intTotalAmt - intTotal;
		   System.out.println("The Total difference in the amount is: " + diffAmt);
	}

}
