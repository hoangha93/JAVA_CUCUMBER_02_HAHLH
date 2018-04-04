package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import pages.NewCustomerPage;

public class NewCustomerPageSteps extends AbstractTest {
	WebDriver driver;
	private World world;

	NewCustomerPage newCustomerPage;
	String rearEmail = randomNumber() + "@gmail.com";

	public NewCustomerPageSteps(World world_) {
		driver = Hooks.openBrowser();
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
		this.world = world_;
	}

	@Given("^Input data to all fields required$")
	public void inputDataToAllFieldsRequired(DataTable table) {
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		newCustomerPage.inputCustomerName(customer.get(0).get("CustomerName"));
		newCustomerPage.inputDateOfBirth(customer.get(0).get("DateOfBirth"));
		newCustomerPage.inputAddress(customer.get(0).get("Address"));
		newCustomerPage.inputCity(customer.get(0).get("City"));
		newCustomerPage.inputState(customer.get(0).get("State"));
		newCustomerPage.inputPin(customer.get(0).get("PIN"));
		newCustomerPage.inputMobile(customer.get(0).get("Phone"));
		newCustomerPage.inputEmail(customer.get(0).get("Email") + rearEmail);
		newCustomerPage.inputPassword(customer.get(0).get("Password"));
	}

	@Given("^Click to Submit button$")
	public void clickToSubmitButton() {
		newCustomerPage.clickSubmit();
	}

	@Then("^Verify Customer created successfully with message \"([^\"]*)\"$")
	public void verifyCustomerCreatedSuccessfullyWithMessage(String message) {
		verifyEquals(message, newCustomerPage.getMessage());
	}

	@Then("^Customer infomation should be shown$")
	public void customerInfomationShouldBeShown(DataTable table) {
		//SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		verifyEquals(customer.get(0).get("CustomerName"), newCustomerPage.getCustomerName());
		//verifyEquals(customer.get(0).get("DateOfBirth"), df.format(newCustomerPage.getDateOfBirth() + ""));
		verifyEquals(customer.get(0).get("Address"), newCustomerPage.getAddress());
		verifyEquals(customer.get(0).get("City"), newCustomerPage.getCity());
		verifyEquals(customer.get(0).get("Phone"), newCustomerPage.getMobile());
		verifyEquals(customer.get(0).get("Email") + rearEmail, newCustomerPage.getEmail());
	}

	@Then("^Get CustomerID for edit customer function$")
	public void getCustomerIDForEditCustomerFunction() {
		world.customerId = newCustomerPage.getCustomerId();
	}

	@Given("^I open Edit Customer page$")
	public void iOpenEditCustomerPage() {
		newCustomerPage.openEditCustomerPage(driver);
	}
}
