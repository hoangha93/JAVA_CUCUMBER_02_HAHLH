package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pages.EditCustomerPage;

public class EditCustomerPageSteps extends AbstractTest {
	WebDriver driver;
	private ShareState shareState;

	EditCustomerPage editCustomerPage;

	public EditCustomerPageSteps(ShareState shareState) {
		driver = Hooks.openBrowser();
		editCustomerPage = PageFactoryManager.getEditCustomerPage(driver);
		this.shareState = shareState;
	}

	@When("^Input CustomerID$")
	public void inputCustomerID() {
		editCustomerPage.inputCustomerID(shareState.customerId);
	}

	@Then("^Click to Submit$")
	public void clickToSubmit() {
		editCustomerPage.clickSubmit();
	}

	@And("^I quit browser$")
	public void iQuitBrowser() {
		Hooks.closeBrowser();
	}
}
