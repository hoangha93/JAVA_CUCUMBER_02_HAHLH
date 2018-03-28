package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DeleteAccountPageUI;

public class DeleteAccountPage extends AbstractPage {
	WebDriver driver;

	public DeleteAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAccountID(String accountID) {
		waitForControlVisible(driver, DeleteAccountPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NO_TXT, accountID);
	}

	public void clickSubmitButton() {
		clickToElement(driver, DeleteAccountPageUI.SUBMIT_BTN);
	}

	public void confirmAccept() {
		waitForAlertPress(driver);
		acceptAlert(driver);
	}

	public String getSuccessMessage() {
		waitForAlertPress(driver);
		return getTextAlert(driver);
	}

}
