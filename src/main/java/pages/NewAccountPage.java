package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewAccountPageUI;

public class NewAccountPage extends AbstractPage {
	WebDriver driver;

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerID(String customerId) {
		waitForControlVisible(driver, NewAccountPageUI.CUSTOMER_ID_TXT);
		sendkeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TXT, customerId);
	}

	public void selectAccountType(String accountType) {
		selectItemInDropdown(driver, NewAccountPageUI.ACCOUNT_SLC, accountType);
	}

	public void inputInitialDeposit(String initialDeposit) {
		sendkeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TXT, initialDeposit);
	}

	public void clickSubmitBtn() {
		clickToElement(driver, NewAccountPageUI.SUBMIT_BTN);
	}

	public String getMessage() throws InterruptedException {
		Thread.sleep(2000);
		waitForControlPresence(driver, NewAccountPageUI.SUCCESS_MES);
		return getTextElement(driver, NewAccountPageUI.SUCCESS_MES);
	}

	public String getInitialDeposit() {
		return getTextElement(driver, NewAccountPageUI.CURRENT_AMOUNT_TXT);
	}

	public String getAccountID() {
		return getTextElement(driver, NewAccountPageUI.ACCOUNT_ID_TXT);
	}

	public String getCustomerID() {
		return getTextElement(driver, NewAccountPageUI.CUSTOMER_ID);
	}

	public String getCustomerName() {
		return getTextElement(driver, NewAccountPageUI.CUSTOMER_NAME);
	}

	public Object getEmail() {
		return getTextElement(driver, NewAccountPageUI.CUSTOMER_EMAIL);
	}

	public Object getAccountType() {
		return getTextElement(driver, NewAccountPageUI.ACCOUNT_TYPE_CREATED);
	}

}
