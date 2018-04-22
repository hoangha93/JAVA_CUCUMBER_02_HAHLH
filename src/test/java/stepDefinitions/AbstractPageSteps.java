package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pages.AbstractPageObject;
import pages.DepositPage;
import pages.EditCustomerPage;
import pages.HomePage;
import pages.NewAccountPage;
import pages.NewCustomerPage;
import pages.WithdrawalPage;

public class AbstractPageSteps extends ShareData {

	WebDriver driver;
	private AbstractPageObject abstractPage;
	private AbstractTest abstractTest;
	private NewCustomerPage newCustomerPage;
	private EditCustomerPage editCustomerPage;
	private NewAccountPage newAccountPageObject;
	private DepositPage depositPage;
	private WithdrawalPage withdrawalPage;
	private HomePage homePage;
	private ShareData shareData;
	String RandomNumber=""+AbstractTest.randomNumber();

	public AbstractPageSteps(ShareData shareData_) {
		driver = Hooks.openBrowser();
		abstractPage = PageFactoryManager.getAbstractPage(driver);
		abstractTest =new AbstractTest();
		this.shareData = shareData_;
	}

    @And("^I input to \"([^\"]*)\" textbox with data \"([^\"]*)\"$")
    public void iInputToSomethingTextboxWithDataSomething(String textboxName, String value) {
    	abstractPage.inputToDynamicTextbox(textboxName,value);
    }
    
    @And("^I input to \"([^\"]*)\" textbox with random data \"([^\"]*)\"$")
    public void iInputToSomethingTextboxWithRandomDataSomething(String textboxName, String value) {
    	value=RandomNumber+value;
    	abstractPage.inputToDynamicTextbox(textboxName,value);
    }
    
    @And("^I input to \"([^\"]*)\" textarea with data \"([^\"]*)\"$")
    public void iInputToSomethingTextAreaWithDataSomething(String textAreaName, String value) {
    	abstractPage.inputToDynamicTextArea(textAreaName,value);
    }
    
    @And("^I click to \"([^\"]*)\" radiobutton$")
    public void iClickToSomethingRadioButton(String radioButtonValue) {
    	abstractPage.clickToDynamicRadioButton(radioButtonValue);
    }
    
    @And("^I select \"([^\"]*)\" dropdown list is\"([^\"]*)\"$")
    public void iSelectSomethingDropdownListIssomething(String selectName, String value) {
    	abstractPage.selectToDynamicDropDownList(selectName,value);
    }
	
	@Given("^I click to \"([^\"]*)\" button$")
	public void click_to_Something_button(String buttonName) {
		abstractPage.clickDynamicButton(buttonName);
	}

	@Then("^Verify created or edited successfully with message \"(.*?)\"$")
	public void verify_Customer_created_successfully_with_message(String message) {
		abstractPage.isNewEditDisplay(message);
	}
	
    @And("^I verify to \"([^\"]*)\" with data \"([^\"]*)\"$")
    public void iVerifyToSomethingWithDataSomething(String customerName, String value){
    	abstractTest.verifyEquals(value, abstractPage.getDataDynamic(customerName));
    }
    
    @And("^I verify to \"([^\"]*)\" with random data \"([^\"]*)\"$")
    public void iVerifyToSomethingWithRandomDataSomething(String customerName, String value){
    	value=RandomNumber+value;
    	abstractTest.verifyEquals(value, abstractPage.getDataDynamic(customerName));
    }
    
    @When("^I input (first|second) Account ID$")
	public void iInputFirstAccountID(String account) {
		if (account.equalsIgnoreCase("first")) {
			abstractPage.inputAccountNo(shareData.firstAccountId);
		}
		if (account.equalsIgnoreCase("second")) {
			abstractPage.inputAccountNo(shareData.secondAccountId);
	}
}

	@Given("^I open \"(.*?)\" page$")
	public void i_open_dynamic_page(String dynamicPage) {
		switch (dynamicPage) {
		case "New Customer":
			newCustomerPage = abstractPage.openNewCustomerPage(driver);
			break;
		case "Edit Customer":
			editCustomerPage = abstractPage.openEditCustomerPage(driver);
			break;
		case "New Account":
			newAccountPageObject = abstractPage.openNewAccountPage(driver);
			break;
		case "Deposit":
			depositPage = abstractPage.openDepositPage(driver);
			break;
		case "Withdrawal":
			withdrawalPage = abstractPage.openWithdrawalPage(driver);
			break;
		default:
			homePage = PageFactoryManager.getHomePage(driver);
			break;
		}
	}
}