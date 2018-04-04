package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import pages.HomePage;

public class HomePageSteps {
	WebDriver driver;

	HomePage homePage;

	public HomePageSteps() {
		driver = Hooks.openBrowser();
		homePage = PageFactoryManager.getHomePage(driver);
	}

	@Then("^I verify Homepage displayed with message \"([^\"]*)\"$")
	public void iVerifyHomepageDisplayedWithMessageSomething(String message) {
		Assert.assertEquals(message, homePage.getHomepageMessage());
	}

	@Given("^I open New Customer page$")
	public void iOpenNewCustomerPage() {
		homePage.openNewCustomerPage(driver);
	}
}
