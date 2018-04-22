package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import pages.EditCustomerPage;
import pages.NewCustomerPage;

public class NewCustomerPageSteps extends AbstractTest {
	WebDriver driver;
	private ShareData shareState;

	NewCustomerPage newCustomerPage;
	EditCustomerPage editCustomerPage;
	String rearEmail = randomNumber() + "@gmail.com";

	public NewCustomerPageSteps(ShareData shareState) {
		driver = Hooks.openBrowser();
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
		this.shareState = shareState;
	}

	@Then("^Get CustomerID for edit customer function$")
	public void getCustomerIDForEditCustomerFunction() {
		ShareData.customerId = newCustomerPage.getCustomerId();
	}
}
