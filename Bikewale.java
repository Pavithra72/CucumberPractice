package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.Hooks;

public class Bikewale {
	public static JavascriptExecutor js;

	private Hooks hooks;
		
		public Bikewale(Hooks hooks) {
			this.hooks = hooks;
		}

		@Given("Go to https:\\/\\/www.bikewale.com\\/")
		public void go_to_https_www_bikewale_com() throws InterruptedException {
			hooks.getDriver().get("https://www.bikewale.com/");
			Thread.sleep(1000);
		}

		@Then("Go to menu and click new bikes")
		public void go_to_menu_and_click_new_bikes() throws InterruptedException {
			hooks.getDriver().findElement(By.xpath("//span[@class='navbarBtn nav-icon']")).click();
			hooks.getDriver().findElement(By.xpath("//span[text()='New Bikes']")).click();
			Thread.sleep(500);
		}

		@Then("Click New Bikes Then compare bikes")
		public void click_New_Bikes_Then_compare_bikes() throws InterruptedException {
hooks.getDriver().findElement(By.xpath("(//a[@href='/compare-bikes/'])[2]")).click();
			
			Thread.sleep(2000);		
			}

		@Then("Add first bike as Royal Enfield and model as Thunderbird {int}")
		public void add_first_bike_as_Royal_Enfield_and_model_as_Thunderbird(Integer int1) throws InterruptedException {
			hooks.getDriver().findElementByXPath("(//span[@class='box-label'])[1]").click();
			 Thread.sleep(500);
			 hooks.getDriver().findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[1]").click();
			 hooks.getDriver().findElementByXPath("//li[text()='Royal Enfield']").click();
			 hooks.getDriver().findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[2]").click();
			 hooks.getDriver().findElementByXPath("//li[text()='Thunderbird 350']").click();
		 
			 Thread.sleep(1000);		
		}

		@Then("Add second bike Jawa, model as {int} and version Dual Channel ABS - BS VI")
		public void add_second_bike_Jawa_model_as_and_version_Dual_Channel_ABS_BS_VI(Integer int1) throws InterruptedException {
			hooks.getDriver().findElementByXPath("(//span[@class='add-icon'])[2]").click();
			  Thread.sleep(500);
			  hooks.getDriver().findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[4]").click();
			  Thread.sleep(500);
			  hooks.getDriver().findElementByXPath("(//li[text()='Jawa'])[2]").click();
			  hooks.getDriver().findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[5]").click();
			  Thread.sleep(500);
			  hooks.getDriver().findElementByXPath("//li[text()='42']").click();
			  hooks.getDriver().findElementByXPath("(//select[@class='chosen-select select-type-version']/following-sibling::div)[2]").click();
			  Thread.sleep(500);
			  hooks.getDriver().findElementByXPath("//li[text()='Dual Channel ABS - BS VI']").click();
			  Thread.sleep(1000);
		}

		@Then("Add bike brand Kawasaki model as Ninja {int}")
		public void add_bike_brand_Kawasaki_model_as_Ninja(Integer int1) throws InterruptedException {
			hooks.getDriver().findElement(By.xpath("(//span[@class='add-icon'])[3]")).click();
			Thread.sleep(500);
			hooks.getDriver().findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[7]").click();
			Thread.sleep(500);
			hooks.getDriver().findElement(By.xpath("(//li[text()='Kawasaki'])[3]")).click();
			Thread.sleep(500);
			hooks.getDriver().findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[8]").click();
			Thread.sleep(500);
			hooks.getDriver().findElement(By.xpath("//li[text()='Ninja 300']")).click();
			Thread.sleep(1000);

		}

		@Then("click compare")
		public void click_compare() throws InterruptedException {
			hooks.getDriver().findElement(By.id("btnCompare")).click();
		Thread.sleep(2000);	
		
		}

		@Then("Find and print the maximum overall rating of all the bikes and find the max")
		public void find_and_print_the_maximum_overall_rating_of_all_the_bikes_and_find_the_max() {
		   List<WebElement> overallRatings = hooks.getDriver().findElementsByXPath("//span[@class='font20 font-bold']");
		   List<WebElement> bikesName = hooks.getDriver().findElementsByXPath("//a[@class='item-target-link underline-none ']/p");
		   Map<String, String> map = new LinkedHashMap<String, String>();
		   for(int i=0;i<overallRatings.size();i++) {
			   map.put(overallRatings.get(i).getText(), bikesName.get(i).getText());
		   }
		   
		   for (Entry<String, String> eachEle : map.entrySet()) {
			   System.out.println(eachEle.getKey()+"----->"+eachEle.getValue());
			   	
		}
		   
		   List<Double> lstRatings = new ArrayList<Double>();
		    for (int i = 0; i < overallRatings.size(); i++) {
		    	lstRatings.add(Double.parseDouble(overallRatings.get(i).getText()));
		    }
		   
		    Collections.sort(lstRatings); 
		    System.out.println("The Max Rating:"+Collections.max(lstRatings));

		   
		}


}
