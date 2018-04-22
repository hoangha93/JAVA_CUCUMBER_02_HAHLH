package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageFactoryManager;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pages.NewAccountPage;

public class NewAccountPageSteps {
	WebDriver driver;
	private ShareData shareState;

	NewAccountPage newAccountPage;

	public NewAccountPageSteps(ShareData shareState) {
		driver = Hooks.openBrowser();
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);
		this.shareState = shareState;
	}

	@When("^Get (first|second) AccountID$")
	public void getFirstAccountID(String account) {
		if (account.equalsIgnoreCase("first")) {
			ShareData.firstAccountId = newAccountPage.getAccountID();
		}
		if (account.equalsIgnoreCase("second")) {
			ShareData.secondAccountId = newAccountPage.getAccountID();
		}
	}
}
