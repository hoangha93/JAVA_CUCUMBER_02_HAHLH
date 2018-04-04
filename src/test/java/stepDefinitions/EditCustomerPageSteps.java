package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pages.EditCustomerPage;

public class EditCustomerPageSteps extends AbstractTest {
	WebDriver driver;
	private World world;

	EditCustomerPage editCustomerPage;

	public EditCustomerPageSteps(World world_) {
		driver = Hooks.openBrowser();
		editCustomerPage = PageFactoryManager.getEditCustomerPage(driver);
		this.world = world_;
	}

	@When("^Input CustomerID$")
	public void inputCustomerID() {
		editCustomerPage.inputCustomerID(world.customerId);
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
