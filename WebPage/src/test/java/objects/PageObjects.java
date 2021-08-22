package objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.Scenario;

public class PageObjects {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='lbl_val_1']")
	public WebElement value1;
	@FindBy(xpath = "//input[@id='txt_val_1']")
	public WebElement value1TextInputBox;
	@FindBy(xpath = "//input[@id='lbl_val_2']")
	public WebElement value2;
	@FindBy(xpath = "//input[@id='txt_val_2']")
	public WebElement value2TextInputBox;
	@FindBy(xpath = "//input[@id='lbl_val_3']")
	public WebElement value3;
	@FindBy(xpath = "//input[@id='txt_val_4']")
	public WebElement value3TextInputBox;
	@FindBy(xpath = "//input[@id='lbl_val_4']")
	public WebElement value4;
	@FindBy(xpath = "//input[@id='txt_val_5']")
	public WebElement value4TextInputBox;
	@FindBy(xpath = "//input[@id='lbl_val_5']")
	public WebElement value5;
	@FindBy(xpath = "//input[@id='txt_val_6']")
	public WebElement value5TextInputBox;
	@FindBy(xpath = "//input[@id='lbl_ttl_val']")
	public WebElement totalVal;
	@FindBy(xpath = "//input[@id='txt_ttl_val']")
	public WebElement totalValTextBox;
	
	
	public PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pageValidation() throws Exception {
		String title = driver.getTitle();
		assertEquals("exercise1", title);
	}
	
	public void valuesCountValidation(WebElement value) {
		List<WebElement> valExpected = driver.findElements(By.xpath("label_of_the_value_xpath"));
		int count1 = valExpected.size();
		
		List<WebElement> valActualPresent = driver.findElements(By.xpath("text_field_value_xpath"));
		int count2 = valActualPresent.size();
		
		assertEquals(count1, count2);
	}
	
	public void zeroValueValidation(WebElement element) {
		String val = element.getText();
		if(val.isEmpty()) {
			assertTrue(false);
		}else {
			String value = element.getText();
			String currency = value.substring(1);
			Double currency_val = Double.parseDouble(currency);
			if(currency_val!=0) {
				assertTrue(true);
			}
		}
	}
	
	public void currencyValidation(WebElement element) {
		String val = element.getText();
		if(val.charAt(0)=='$') {
			assertTrue(true);
		}
	}
	
	public void totalBalanace(WebElement totalValTextBox) {
		
		String totalVal = totalValTextBox.getText();
		String totalVal1 = totalVal.substring(1);
		Double totalValue = Double.parseDouble(totalVal1);
		
		List<WebElement> valActualPresent = driver.findElements(By.xpath("text_field_value_xpath"));
		int count = valActualPresent.size(); //6
		Double[] val_list = new Double[count];
		int a =0;
		for(WebElement i : valActualPresent) {
			while(a!=count-1) {
				String str = i.getText();
				String str1 = str.substring(1);
				double val = Double.parseDouble(str1);
				val_list[a] = val;
				a++;
			}
		}
		double sum = 0;
		for(int k=0;k<=val_list.length;k++) {
			sum = sum+val_list[k];
		}
		if(totalValue.equals(sum)) {
			System.out.println("Sum validation successful");
		}else {
			assertTrue(false);
		}
	
	}
	
	public void TearDownScenarioFail(Scenario scn) throws Exception {
		
		if(scn.isFailed()) {
			TakesScreenshot SSName = (TakesScreenshot)this.driver;
			File FileName = SSName.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(FileName,new File("WebPage\\TestOutput\\"+"ImageName"+".PNG"));
		}
	}
}
