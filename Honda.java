package steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.Hooks;

public class Honda {
	
	public static Map<String, String> duoDetails;
	public static Map<String, String> activaDetails;
	
	private Hooks hooks;
	
	public Honda(Hooks hooks) {
		this.hooks = hooks;
	}
	
	@Given("Go to https:\\/\\/www.honda2wheelersindia.com\\/")
	public void go_to_https_www_honda_wheelersindia_com() throws InterruptedException {
		hooks.getDriver().get("https://www.honda2wheelersindia.com/");
		Thread.sleep(1000);
		hooks.getDriver().findElementByXPath("//button[@class='close']").click();
		Thread.sleep(1000);

	}

	@Then("Click on scooters and click dio")
	public void click_on_scooters_and_click_dio() throws InterruptedException {
		hooks.getDriver().findElementByXPath("(//a[text()='Scooter'])[1]").click();
		Thread.sleep(1000);
		hooks.getDriver().findElement(By.xpath("//img[@src='/assets/images/thumb/dioBS6-icon.png']")).click();
	}

	@Then("Click on Specifications and mouseover on Engine")
	public void click_on_Specifications_and_mouseover_on_Engine() throws InterruptedException {
		hooks.getDriver().findElementByXPath("//a[text()='Specifications']").click();
		Thread.sleep(2000);
		WebElement eleengine1 = hooks.getDriver().findElementByXPath("//a[text()='ENGINE']");
		Actions builder = new Actions(hooks.getDriver());
		builder.moveToElement(eleengine1).perform();
		Thread.sleep(1000);

	}

	@Then("Put all the details as key and value into Map")
	public void put_all_the_details_as_key_and_value_into_Map() {
		System.out.println("*****************Duo Details*****************");
		duoDetails = new LinkedHashMap<String, String>(); 
		List<WebElement> engineHeader = hooks.getDriver().findElementsByXPath("(//ul[@class='tab_content'])[2]/li/span[1]");
		List<WebElement> engineValue = hooks.getDriver().findElementsByXPath("(//ul[@class='tab_content'])[2]/li/span[2]");
		
		for(int i=0; i <engineValue.size(); i++) {
			duoDetails.put(engineHeader.get(i+1).getText(), engineValue.get(i).getText());
		}
		for (Entry<String, String> eachString : duoDetails.entrySet()) {
			System.out.println(eachString.getKey()+"--->"+eachString.getValue());
		}
	

//		int detailsSize = hooks.getDriver().findElementsByXPath("(//ul[@class='tab_content'])[2]//li").size();
//		duoDetails = new LinkedHashMap<String, String>(); 
//		for(int i=2;i<=detailsSize;i++) {
//			String duoKeys = hooks.getDriver().findElementByXPath("//ul[@class='tab_content']/li["+i+"]/span[1]").getText();
//			String duoVlaues = hooks.getDriver().findElementByXPath("//ul[@class='tab_content']/li["+i+"]/span[2]").getText();
//			duoDetails.put(duoKeys, duoVlaues);
//		}
//		
//		for (Entry<String, String> eachEntry : duoDetails.entrySet()) {
//			System.out.println(eachEntry.getKey()+"----->"+eachEntry.getValue());
//			
//		}
	}

	@Then("Go to Scooters and click Activa 125")
	public void go_to_Scooters_and_click_Activa() throws InterruptedException {
		hooks.getDriver().findElementByXPath("(//a[text()='Scooter'])[1]").click();
		Thread.sleep(2000);
		// driver.findElementByXPath("(//div[@class='owl-item']/following::img)[5]").click();
		hooks.getDriver().findElementByXPath("//img[@src='/assets/images/thumb/activa-125new-icon.png']").click();

	}

	@Then("Put All its Engine Specification into another Map same as like dio")
	public void put_All_its_Engine_Specification_into_another_Map_same_as_like_dio() throws InterruptedException {
		hooks.getDriver().findElementByXPath("//a[text()='Specifications']").click();
		Thread.sleep(3000);
		WebElement eleengine2 = hooks.getDriver().findElementByXPath("//a[text()='ENGINE']");
		Actions builder2 = new Actions(hooks.getDriver());
		builder2.moveToElement(eleengine2).perform();
		Thread.sleep(2000);
		
		System.out.println("*****************Activa 125 Details*****************");
		activaDetails = new LinkedHashMap<String, String>(); 
		List<WebElement> engineHeader = hooks.getDriver().findElementsByXPath("(//ul[@class='tab_content'])[2]/li/span[1]");
		List<WebElement> engineValue = hooks.getDriver().findElementsByXPath("(//ul[@class='tab_content'])[2]/li/span[2]");
		
		for(int i=0; i <engineValue.size(); i++) {
			activaDetails.put(engineHeader.get(i+1).getText(), engineValue.get(i).getText());
		}
		for (Entry<String, String> eachString : activaDetails.entrySet()) {
			System.out.println(eachString.getKey()+"--->"+eachString.getValue());
		}

//		int detailsSize = hooks.getDriver().findElementsByXPath("(//ul[@class  = 'tab_content'])[2]//li").size();
//		 activaDetails = new LinkedHashMap<String, String>(); 
//		for(int i=2;i<=detailsSize;i++) {
//			String activaKeys = hooks.getDriver().findElementByXPath("//ul[@class='tab_content']/li["+i+"]/span[1]").getText();
//			String activaVlaues = hooks.getDriver().findElementByXPath("//ul[@class='tab_content']/li["+i+"]/span[2]").getText();
//			activaDetails.put(activaKeys, activaVlaues);
//		}
//		
//		for (Entry<String, String> eachEntry : activaDetails.entrySet()) {
//			System.out.println(eachEntry.getKey()+"----->"+eachEntry.getValue());
//			
//		}
	}
		

	

	@Then("Compare Dio and Activa Maps and print the different values of the samekeys.")
	public void compare_Dio_and_Activa_Maps_and_print_the_different_values_of_the_samekeys() {
		System.out.println("***************************Comparison of two scooters values***********************");
		List<String> dioKeys = new ArrayList<String>(duoDetails.keySet());
		List<String> dioValues = new ArrayList<String>(duoDetails.values());
		List<String> activaKeys = new ArrayList<String>(activaDetails.keySet());
		List<String> activaValues = new ArrayList<String>(activaDetails.values());
		if(dioKeys.size() == activaKeys.size()) {
			for(int i = 0; i <dioKeys.size(); i++) {
				if(dioKeys.get(i).equals(activaKeys.get(i))) {
					if(!dioValues.get(i).equalsIgnoreCase(activaValues.get(i))){
						System.out.println("The dio value "+dioValues.get(i)+" for the key "+dioKeys.get(i)+" doesn't match with the activa value "+activaValues.get(i));
					}
				}
			}
		}
	}

	@Then("Click FAQ from Menu and Click dio under Browse By Product")
	public void click_FAQ_from_Menu_and_Click_dio_under_Browse_By_Product() throws InterruptedException {
		hooks.getDriver().findElementByXPath("(//a[text()='FAQ'])[1]").click();
		Thread.sleep(2000);
		WebElement dio = hooks.getDriver().findElementByXPath("//a[text()='Dio BS-VI']");
		dio.click();
		Thread.sleep(2000);


	}

	@Then("Click  Vehicle Price and Select scooter, Dio BS-VI from the dropdown and click submit")
	public void click_Vehicle_Price_and_Select_scooter_Dio_BS_VI_from_the_dropdown_and_click_submit() {
		hooks.getDriver().findElementByXPath("//a[text()=' Vehicle Price']").click();
		hooks.getDriver().findElementByXPath("//button[@id='submit6']").click();
	}

	@Then("click the price link,  Go to the new Window and select the state, city")
	public void click_the_price_link_Go_to_the_new_Window_and_select_the_state_city() throws InterruptedException {
		hooks.getDriver().findElementByXPath("//a[text()='Click here to know the price of Dio BS-VI.']").click();
		Thread.sleep(3000);
		Set<String> nextWindow = hooks.getDriver().getWindowHandles();
		List<String> allList = new ArrayList<String>(nextWindow);
		hooks.getDriver().switchTo().window(allList.get(1));
		// state selected as Tamil Nadu
				WebElement stateId = hooks.getDriver().findElementById("StateID");
				Select selectStateId = new Select(stateId);
				selectStateId.selectByVisibleText("Tamil Nadu");
		// city selected as Chennai
				WebElement cityId = hooks.getDriver().findElementById("CityID");
				Select selectCityId = new Select(cityId);
				selectCityId.selectByVisibleText("Chennai");
				hooks.getDriver().findElementByXPath("//button[text()='Search']").click();


	}

	@Then("Print the price and model")
	public void print_the_price_and_model() {
		System.out.println("****************Price and Model******************");
		Map<String, String> priceOfScooters = new LinkedHashMap();

		String scooterModel = "";
		String price = "";

		for (int i = 1; i <= 2; i++) {
			scooterModel = hooks.getDriver()
					.findElementByXPath("//table[@id='gvshow']//tr[" + i + "]//td[contains(text(),'DIO')]")
					.getText();
			price = hooks.getDriver()
					.findElementByXPath(
							"//table[@id='gvshow']//tr[" + i + "]//td[contains(text(),'DIO')]/following-sibling::td")
					.getText();

			priceOfScooters.put(scooterModel, price);

		}

		for (Entry<String, String> each : priceOfScooters.entrySet()) {
			System.out.println(each.getKey() + " price is " + each.getValue());
			
		}


	}

	@Then("Click Product Enquiry and Fill all the * field except Mobile, check the terms and conditions box and click submit")
	public void click_Product_Enquiry_and_Fill_all_the_field_except_Mobile_check_the_terms_and_conditions_box_and_click_submit() {
	    hooks.getDriver().findElementByXPath("//span[text()='Product Enquiry ']").click();
	    WebElement model = hooks.getDriver().findElementById("ModelID");
	    Select modelInterested = new Select(model);
	    modelInterested.selectByVisibleText("Dio BS-VI");
	    
	    WebElement state = hooks.getDriver().findElementById("StateID");
	    Select sltState = new Select(state);
	    sltState.selectByVisibleText("Tamil Nadu");
	    
	    WebElement city = hooks.getDriver().findElementById("CityID");
	    Select sltCity = new Select(city);
	    sltCity.selectByVisibleText("Chennai");
	    
	    WebElement dealer = hooks.getDriver().findElementById("DealerID");
	    Select sltDealer = new Select(dealer);
	    sltDealer.selectByVisibleText("Akshaya Honda");
	    
	    WebElement title = hooks.getDriver().findElementById("TitleID");
	    Select sltTitle = new Select(title);
	    sltTitle.selectByVisibleText("Ms.");
	    
	    hooks.getDriver().findElement(By.id("Name")).sendKeys("Pavithra");
	    hooks.getDriver().findElement(By.id("Email")).sendKeys("pavi7_89@yahoo.com");
	    hooks.getDriver().findElement(By.id("TermsAndConditions")).click();
	    hooks.getDriver().findElement(By.id("submit")).click();
	    
	}

	@Then("Verify the error message under the mobile number field.")
	public void verify_the_error_message_under_the_mobile_number_field() {
		System.out.println("************Error message varification*******************");
		String pleaseEnterMobile = hooks.getDriver().findElement(By.xpath("//span[@for='MobileNo']")).getText();   
		System.out.println("The error message is: " + pleaseEnterMobile);
		if(pleaseEnterMobile.equalsIgnoreCase("Please enter mobile no.")) {
			System.out.println("The Message is verified and it is same");
		}else {
			System.out.println("The Message is verified and its not same");
		}
	
	}


}
