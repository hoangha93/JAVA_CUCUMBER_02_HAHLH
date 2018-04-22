package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import pages.HomePage;

public class HomePageSteps extends AbstractTest {
	WebDriver driver;

	HomePage homePage;

	public HomePageSteps() {
		driver = Hooks.openBrowser();
		homePage = PageFactoryManager.getHomePage(driver);
	}

	@Then("^I verify Homepage displayed with message \"([^\"]*)\"$")
	public void iVerifyHomepageDisplayedWithMessageSomething(String message) {
		verifyEquals(message, homePage.getHomepageMessage());
	}
}
