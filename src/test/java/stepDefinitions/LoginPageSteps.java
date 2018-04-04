package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pages.LoginPage;

public class LoginPageSteps {
	WebDriver driver;

	LoginPage loginPage;

	public LoginPageSteps() {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Given("^I input \"([^\"]*)\" and \"([^\"]*)\"$")
	public void iInputSomethingAndSomething(String userName, String password) {
		loginPage.inputUserName(userName);
		loginPage.inputPassword(password);
	}

	@When("^I click to Login button$")
	public void iClickToLoginButton() {
		loginPage = new LoginPage(driver);
		loginPage.clickLogin();
	}
}
