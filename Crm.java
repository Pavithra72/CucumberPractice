package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hooks.Hooks;

public class Crm {
	public static JavascriptExecutor js;
	public String proTitle;
	private Hooks hooks;
		
		public Crm(Hooks hooks) {
			this.hooks = hooks;
		}
	
	@Given("Go to https://demo.1crmcloud.com/")
	public void go_to_https_demo_crmcloud_com() {
		hooks.getDriver().get("https://demo.1crmcloud.com/");

	}

	@Then("Give username as admin and password as admin")
	public void give_username_as_admin_and_password_as_admin() {
		hooks.getDriver().findElementById("login_user").sendKeys("admin");
		hooks.getDriver().findElementById("login_pass").sendKeys("admin");
		
	}

	@And("Choose theme as Claro Theme")
	public void choose_theme_as_Claro_Theme() throws InterruptedException {
		WebElement selectTheme = hooks.getDriver().findElementById("login_theme");
		Select theme = new Select(selectTheme);
		theme.selectByVisibleText("Claro Theme");
		hooks.getDriver().findElementById("login_button").click();
		Thread.sleep(3000);
		
	}

	@Then("Go to Sales and Marketting and click Sales Home")
	public void go_to_Sales_and_Marketting_and_click_Sales_Home() throws InterruptedException {
		WebElement salesMarketing = hooks.getDriver().findElementByXPath("//div[text()='Sales & Marketing']");   
		Actions builder = new Actions(hooks.getDriver());
		builder.moveToElement(salesMarketing).perform();
		Thread.sleep(1000);
		hooks.getDriver().findElementByXPath("//div[text()='Sales Home']").click();
		Thread.sleep(3000);
	}

	@Then("Click Create contact")
	public void click_Create_contact() throws InterruptedException {
		hooks.getDriver().findElementByXPath("//div[text()='Create Contact']").click();
		Thread.sleep(5000);

	}

	@And("Select Title and type First name, Last Name, Email and Phone Numbers")
	public void select_Title_and_type_First_name_Last_Name_Email_and_Phone_Numbers() throws InterruptedException {
		hooks.getDriver().findElementByXPath("//div[@id='DetailFormsalutation-input']").click();
		Thread.sleep(500);
		hooks.getDriver().findElementByXPath("//div[text()='Mrs.']").click();
	//	driver.findElementByXPath("//div[@id='DetailFormsalutation-input']").sendKeys(Keys.ENTER);
		hooks.getDriver().findElementById("DetailFormfirst_name-input").sendKeys("Preetha");
		hooks.getDriver().findElementById("DetailFormlast_name-input").sendKeys("Srini");
		hooks.getDriver().findElementById("DetailFormemail1-input").sendKeys("Preetha@gmail.com");
		hooks.getDriver().findElementById("DetailFormphone_work-input").sendKeys("9710724561");
		
	}

	@And("Select Lead Source as Public Relations and Business Roles")
	public void select_Lead_Source_as_Public_Relations_and_Business_Roles() throws InterruptedException {
		hooks.getDriver().findElementById("DetailFormlead_source-input").click();
		Thread.sleep(500);
		hooks.getDriver().findElementByXPath("//div[text()='Public Relations']").click();
		Thread.sleep(1000);
		hooks.getDriver().findElementById("DetailFormbusiness_role-input").click();
		Thread.sleep(500);
		hooks.getDriver().findElementByXPath("//div[text()='Sales']").click();
		Thread.sleep(1000);	
		}

	@Then("Fill the Primary Address, City, State, Country and Postal Code and click Save")
	public void fill_the_Primary_Address_City_State_Country_and_Postal_Code_and_click_Save() throws InterruptedException {
		hooks.getDriver().findElementById("DetailFormprimary_address_street-input").sendKeys("D 17, MGR Road, Nanganallur");
		hooks.getDriver().findElementById("DetailFormprimary_address_city-input").sendKeys("Chennai");
		hooks.getDriver().findElementById("DetailFormprimary_address_state-input").sendKeys("TamilNadu");
		hooks.getDriver().findElementById("DetailFormprimary_address_country-input").sendKeys("India");
		hooks.getDriver().findElementById("DetailFormprimary_address_postalcode-input").sendKeys("600061");
		hooks.getDriver().findElementById("DetailForm_save2").click();
		Thread.sleep(5000);

	}

	@Then("Click create in Leads")
	public void click_create_and_Leads() throws InterruptedException {

		hooks.getDriver().findElementByXPath("(//button[@type='submit']//span)[5]").click();
		Thread.sleep(4000);
	}

	@And("Fill First & Last name, Status as In Process, Title as Manager and Department as Sales")
	public void fill_First_Last_name_Status_as_In_Process_Title_as_Manager_and_Department_as_Sales() {
	   hooks.getDriver().findElementByXPath("//input[@name='first_name']").sendKeys("Preetha");
	   hooks.getDriver().findElementByXPath("//input[@name='last_name']").sendKeys("Srini");
	   hooks.getDriver().findElementByXPath("(//div[@class='input-field input-field-group rbullet'])[1]").click();
	   hooks.getDriver().findElementByXPath("//div[text()='In Process']").click();
	   hooks.getDriver().findElementByXPath("//input[@name='title']").sendKeys("Manager");
	   hooks.getDriver().findElementByXPath("//input[@name='department']").sendKeys("Sales");
 
	}

	@Then("Select Lead as Public Relations and fill department, Email and Phone Number")
	public void select_Lead_as_Public_Relations_and_fill_department_Email_and_Phone_Number() {
		 hooks.getDriver().findElementByXPath("(//div[@class='input-field input-field-group rbullet'])[2]").click();
		   hooks.getDriver().findElementByXPath("(//div[text()='Public Relations'])[2]").click();
		   hooks.getDriver().findElementByXPath("//input[@name='phone_work']").sendKeys("24567839");
		   hooks.getDriver().findElementByXPath("//input[@name='email1']").sendKeys("Preetha@gmail.com");
	}

	@And("Click Save and View")
	public void click_Save_and_View() throws InterruptedException {

		hooks.getDriver().findElementByXPath("//span[text()='Save & View']").click();
		Thread.sleep(5000);
	}

	@Then("Mouse over on Today's Activities and click Meetings")
	public void mouse_over_on_Today_s_Activities_and_click_Meetings() throws InterruptedException {
		WebElement todayActivities = hooks.getDriver().findElementByXPath("(//div[@class='menu-label'])[1]");
		Actions builder = new Actions(hooks.getDriver());
		builder.moveToElement(todayActivities).perform();
		Thread.sleep(1000);
		hooks.getDriver().findElementByXPath("//div[text()='Meetings']").click();
		Thread.sleep(5000);
		hooks.getDriver().findElementByXPath("(//button[@class='input-button first'])[1]").click();
		Thread.sleep(5000);
	}

	@And("Type Subject as Project Status Status as Planned and Time as tomorrow 3 p.m")
	public void type_Subject_as_Project_Status_Status_as_Planned_and_Time_as_tomorrow_p_m() throws InterruptedException {
		hooks.getDriver().findElementById("DetailFormname-input").sendKeys("Project Status");
		hooks.getDriver().executeScript("window.scrollBy(0, 250)");
		hooks.getDriver().findElementByXPath("//div[@id='DetailFormdate_start-input']").click();
		Thread.sleep(1000);
		hooks.getDriver().findElementByXPath("(//div[@class='grid-cell number-cell text-right day inside current selected responsive']/following::div)[1]").click();
		hooks.getDriver().findElementByXPath("(//input[@class='input-text'])[4]").clear();
		hooks.getDriver().findElementByXPath("(//input[@class='input-text'])[4]").sendKeys("15:00");
		hooks.getDriver().findElementByXPath("//div[@class='active-icon uii-accept uii-lg uii']").click();
		Thread.sleep(1000);
	}

	@And("Click Add paricipants, add your created Lead name and click Save")
	public void click_Add_paricipants_add_your_created_Lead_name_and_click_Save() throws InterruptedException {
		hooks.getDriver().findElementByXPath("//button[@name='addInvitee']").click();
		Thread.sleep(500);
		hooks.getDriver().findElementByXPath("(//input[@class='input-text'])[4]").sendKeys("Preetha");
		Thread.sleep(500);
		hooks.getDriver().findElementByXPath("(//div[@class='option-cell input-label '])[14]").click();
		hooks.getDriver().findElementByXPath("//span[@id='DetailForm_save2-label']").click();
		Thread.sleep(5000);
		 proTitle = hooks.getDriver().findElementByXPath("//div[@id='_form_header']").getText();
	}

	@Then("Click contacts under Sales and Marketting, search the lead Name and click the name from the result")
	public void click_contacts_under_Sales_and_Marketting_search_the_lead_Name_and_click_the_name_from_the_result() throws InterruptedException {
		WebElement salesMarketing = hooks.getDriver().findElementByXPath("//div[text()='Sales & Marketing']");
		Actions builder1 = new Actions(hooks.getDriver());
		builder1.moveToElement(salesMarketing).perform();
		Thread.sleep(1000);
		hooks.getDriver().findElementByXPath("//div[text()='Contacts']").click();
		Thread.sleep(5000);
		hooks.getDriver().findElementByXPath("//input[@id='filter_text']").sendKeys("Preetha");
		Thread.sleep(500);
		hooks.getDriver().findElementByXPath("(//div[@class='menu-option single'])[15]").click();
		Thread.sleep(5000);

	}

	@And("Check weather the Meeting is assigned to the contact.")
	public void check_weather_the_Meeting_is_assigned_to_the_contact() {
		hooks.getDriver().executeScript("window.scrollBy(0, 750)");
		String projectName = hooks.getDriver().findElementByXPath("//span[@class='detailLink']").getText();
		if(projectName.equalsIgnoreCase(proTitle)) {
			System.out.println("The Meeting is scheduled to the created contact under activities section");
		}else {
			System.out.println("The Meeting is not scheduled to the created contact under activities section");
		}
	}


}
