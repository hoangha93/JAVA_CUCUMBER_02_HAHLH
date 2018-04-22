package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.And;
import cucumberOption.Hooks;
import pages.DepositPage;

public class DepositPageSteps extends AbstractTest {
	WebDriver driver;
	private ShareData shareState;

	DepositPage depositPage;

	public DepositPageSteps(ShareData shareState) {
		driver = Hooks.openBrowser();
		depositPage = PageFactoryManager.getDepositPage(driver);
		this.shareState = shareState;
	}

	@And("^I (?:transfer|withdraw) to \"([^\"]*)\" USD$")
	public void iTransferToSomethingUSD(String amount) {
		depositPage.inputAmount(amount);
	}

	@And("^I write (?:comment|description) is \"([^\"]*)\"$")
	public void iWriteCommentIsSomething(String description) {
		depositPage.inputDescription(description);
	}

}
