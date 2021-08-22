package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import objects.PageObjects;

public class ActionsPerform extends PageObjects {
	
	public ActionsPerform(WebDriver driver) {
		super(driver);
	}

	public WebDriver driver;
	PageObjects objpageObject;
	
	@Given("User launches the {string}")
	public void user_launches_the(String webUrl) throws Exception {
	    
		System.setProperty("webdriver.chrome.driver", "WebPage\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(webUrl);
		objpageObject = new PageObjects(driver);
		
	}
	
	@Then("validate successful launch")
	public void validate_successful_launch() throws Exception {
		objpageObject = new PageObjects(driver);
		objpageObject.pageValidation();
	}
	
	@Then("check for the number of value fields")
	public void check_for_the_number_of_value_fields() {
		objpageObject = new PageObjects(driver);
		objpageObject.valuesCountValidation(value1TextInputBox);
		objpageObject.valuesCountValidation(value1);
		objpageObject.valuesCountValidation(value2TextInputBox);
		objpageObject.valuesCountValidation(value2);
		objpageObject.valuesCountValidation(value3TextInputBox);
		objpageObject.valuesCountValidation(value3);
		objpageObject.valuesCountValidation(value4TextInputBox);
		objpageObject.valuesCountValidation(value4);
		objpageObject.valuesCountValidation(value5TextInputBox);
		objpageObject.valuesCountValidation(value5);
		objpageObject.valuesCountValidation(totalValTextBox);
		objpageObject.valuesCountValidation(totalVal);
	}
	
	@Then("validate the values present are nonzero")
	public void validate_the_values_present_are_nonzero() {
		objpageObject = new PageObjects(driver);
		objpageObject.zeroValueValidation(value1TextInputBox);
		objpageObject.zeroValueValidation(value2TextInputBox);
		objpageObject.zeroValueValidation(value3TextInputBox);
		objpageObject.zeroValueValidation(value4TextInputBox);
		objpageObject.zeroValueValidation(value5TextInputBox);
		objpageObject.zeroValueValidation(totalValTextBox);
	}
	
	@Then("validate the values are passed as currencies")
	public void validate_the_values_are_passed_as_currencies() {
		objpageObject = new PageObjects(driver);
		objpageObject.currencyValidation(value1TextInputBox);
		objpageObject.currencyValidation(value2TextInputBox);
		objpageObject.currencyValidation(value3TextInputBox);
		objpageObject.currencyValidation(value4TextInputBox);
		objpageObject.currencyValidation(value5TextInputBox);
		objpageObject.currencyValidation(totalValTextBox);
	}
	
	@Then("validate the sum of values passed is equal to total balance")
	public void validate_the_sum_of_values_passed_is_equal_to_total_balance() {
		objpageObject = new PageObjects(driver);
		objpageObject.totalBalanace(totalValTextBox);
	}

}
