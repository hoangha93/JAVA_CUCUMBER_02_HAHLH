package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DeleteCustomerPageUI;

public class DeleteCustomerPage extends AbstractPage {
	WebDriver driver;

	public DeleteCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerID(String customerId) {
		waitForControlVisible(driver, DeleteCustomerPageUI.CUSTOMER_NO_TXT);
		sendkeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_NO_TXT, customerId);
	}

	public void clickSubmitButton() {
		clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BTN);
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
