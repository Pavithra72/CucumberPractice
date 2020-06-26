package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.Hooks;

public class Naukri {
	public static JavascriptExecutor js;

	private Hooks hooks;
		
		public Naukri(Hooks hooks) {
			this.hooks = hooks;
		}

	@Given("Open naukri.com")
	public void open_naukri_com() throws InterruptedException {
		hooks.getDriver().get("https://www.naukri.com/");
		Thread.sleep(3000);
	}

	@Then("Get the company names from each pop up window and close it")
	public void get_the_company_names_from_each_pop_up_window_and_close_it() throws InterruptedException {
	   Set<String> windows = hooks.getDriver().getWindowHandles();
	   List<String> lst = new ArrayList<String>(windows);
	   hooks.getDriver().switchTo().window(lst.get(1));
	   Thread.sleep(2000);
	   hooks.getDriver().manage().window().maximize();
	   String companyName1 = hooks.getDriver().findElementByXPath("(//img)[1]").getAttribute("alt");
	   System.out.println("The First company name is: "+ companyName1 );
	   hooks.getDriver().switchTo().window(lst.get(2));
	   Thread.sleep(2000);
	   hooks.getDriver().manage().window().maximize();
	   String companyName2 = hooks.getDriver().findElementByXPath("(//img)[1]").getAttribute("alt");
	   System.out.println("The Second company name is: "+ companyName2);
	   hooks.getDriver().switchTo().window(lst.get(0));
	   Thread.sleep(2000); 
	}

	@Then("Now, click on the upload cv button and upload some random image.")
	public void now_click_on_the_upload_cv_button_and_upload_some_random_image() throws InterruptedException {
		WebElement uploadFile = hooks.getDriver().findElement(By.id("file_upload"));
		uploadFile.sendKeys("C:\\Users\\Lenovo\\Desktop\\testFolder\\testfile.png");
		Thread.sleep(2000);
		
		
	}

	@Then("Get the error message printed")
	public void get_the_error_message_printed() {
		String errorMsg = hooks.getDriver().findElement(By.xpath("//div[@class='error-header-desc error']")).getText();
		System.out.println("The Error message is: " + errorMsg);
	}


}
