package system.architecture.exercise.mvc.web.functional;

import org.springframework.beans.factory.annotation.Autowired;

public class CalculatorPage{
	
	private static final String VALUE_ONE_ELEMENT_ID = "firstInput";
	private static final String VALUE_TWO_ELEMENT_ID = "secondInput";
	private static final String SELECT_OPERATION = "operation";
	private static final String SUBMIT_FORM_ID = "calculate";
	
	private String calculatorUrl;
	
	@Autowired
	private PageObject pageObject;
	
	public void open() {
		pageObject.openBrowser();
	}
	
	public void fillForm(String valueone, String valuetwo) {
		pageObject.fillFormField(VALUE_ONE_ELEMENT_ID, valueone);
		pageObject.fillFormField(VALUE_TWO_ELEMENT_ID, valuetwo);
	}
	
	public void selectOperation(String oper) {
		
		pageObject.iSelectOperation(oper);
	}
	
	public String getSum(){
		
		return pageObject.resultOfTheCalculus();
	}
	
	public void submitForm() {
		pageObject.submitForm(SUBMIT_FORM_ID);		
	}
	
	public void setCalculatorUrl(String url) {
		this.calculatorUrl = url;
	}	
	
	
	
}
