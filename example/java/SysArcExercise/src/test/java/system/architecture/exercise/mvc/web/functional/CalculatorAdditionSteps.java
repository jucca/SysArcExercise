package system.architecture.exercise.mvc.web.functional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Steps
public class CalculatorAdditionSteps extends CalculatorBase{

	@Autowired
	@Qualifier("calculatorPage")
	private CalculatorPage calculatorPage;
	
    @BeforeStories
    public void setDriver(){
        driver = getDriver();
    }
	
	@Given("Given Calculator is started")
	public void aNewCalcularStarted(){
		calculatorPage.open();
	}
	
	@Given("I have entered <valueone> and <valuetwo> into the calculator and select addition <operation>")
	public void additionCalculation(@Named("valueone")double valueone, @Named("valuetwo")double valuetwo, @Named("operation")String operation){
		calculatorPage.fillForm(Double.toString(valueone), Double.toString(valuetwo));
		calculatorPage.selectOperation(operation);
	}
	
	@When("I calculate")
	public void addCalculationInitiated() {
		calculatorPage.submitForm();
	}
	@Then("I should see following result: <result>I should see following result: <result>")
	public void stockStatusShouldBeShowed(@Named("result")double result) {
		assertThat(calculatorPage.getSum(), is(Double.toString(result)));
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
}
