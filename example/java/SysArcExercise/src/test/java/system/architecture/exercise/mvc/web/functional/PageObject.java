package system.architecture.exercise.mvc.web.functional;

import org.jbehave.core.annotations.*;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PageObject {

    private WebDriver driver;
    
	public void fillFormField(String fieldId, String content) {
		WebElement element = driver.findElement(By.id(fieldId));
		element.clear();
		element.sendKeys(content);
	}
	
	public void submitForm(String submitId) {
		WebElement element = driver.findElement(By.id(submitId));
		element.submit();
	}
	
	public String getElementText(String elementId) {
		WebElement element = driver.findElement(By.id(elementId));
		return element.getText();
	}

    public void iEnterValuesToCalculator(String valueone, String valuetwo){

        WebElement firstValueField = driver.findElement(By.id("firstInput"));
        firstValueField.sendKeys(valueone);
        
        WebElement secondValueField = driver.findElement(By.id("secondInput"));
        secondValueField.sendKeys(valuetwo);
    }
   
    public void iClickSubmit() {
        WebElement submitButton = driver.findElement(By.id("calculate"));
        submitButton.click();
    }
    
    public void iSelectOperation(String selection){
    	
     Select	operation = new Select(driver.findElement(By.id("operation")));
     operation.selectByVisibleText(selection);
    }

    public String resultOfTheCalculus(){
        WebElement form = driver.findElement(By.id("sum"));
        String sum = form.getText();

        return sum;
    }

  
    @BeforeScenario
    public void openBrowser() {
	
		File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		FirefoxDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
        driver = new FirefoxDriver();
        driver.get("http://localhost:9999/sae");
    }

    @AfterScenario
    public void closeBrowser() {
        driver.quit();
    }
 
	public void setWebDriver(WebDriver webDriver) {
		this.driver = webDriver;
	}
}