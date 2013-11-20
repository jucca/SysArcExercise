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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class NavigationSteps extends UserJourneyBase {

    private WebDriver driver;

    @BeforeStories
    public void setDriver(){
        driver = getDriver();
    }

    @Given("I started two weeks ago")
    public void iEnterStartDateTwoWeeksAgo(){
        DateTime twoWeeksAgo = new DateTime().minusWeeks(2);

        String date = twoWeeksAgo.getMonthOfYear() + "/" +
                twoWeeksAgo.getDayOfMonth() + "/" +
                twoWeeksAgo.getYear();

        WebElement startDateField = driver.findElement(By.id("startdate_field"));
        startDateField.sendKeys(date);
    }

    @When("I request my number of vacation days")
    public void iClickSubmit() {
        WebElement submitButton = driver.findElement(By.id("submit_button"));
        submitButton.click();
    }

    @Then("the number of vacation days I have is my daily accrual rate times 14")
    public void vacationDaysAccruedShouldBeTwoWeeksWorthOfAccrual(){
        WebElement form = driver.findElement(By.id("vacationDays"));
        String vacationDays = form.getText();

        String twoWeeksAccrued = String.valueOf((10 / 365.25) * 7 * 2);


        assertThat(vacationDays, containsString(twoWeeksAccrued));
    }

    @BeforeScenario
    public void openBrowser() {
	
		File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		FirefoxDriver _driver = new FirefoxDriver(ffBinary,firefoxProfile);
        driver = new FirefoxDriver();
        driver.get("http://localhost:9999/sae");
    }

    @AfterScenario
    public void closeBrowser() {
        driver.quit();
    }
}