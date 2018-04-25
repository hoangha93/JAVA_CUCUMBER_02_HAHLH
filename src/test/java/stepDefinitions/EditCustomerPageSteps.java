package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pages.EditCustomerPage;

public class EditCustomerPageSteps extends AbstractTest {
	WebDriver driver;
	private ShareData shareState;

	EditCustomerPage editCustomerPage;

	public EditCustomerPageSteps(ShareData shareState) {
		driver = Hooks.openBrowser();
		editCustomerPage = PageFactoryManager.getEditCustomerPage(driver);
		this.shareState = shareState;
	}

	@When("^Input CustomerID$")
	public void inputCustomerID() {
		editCustomerPage.inputCustomerID(ShareData.customerId);
		System.out.println(ShareData.customerId);
	}
}
