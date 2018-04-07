package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.EditCustomerPageUI;

public class EditCustomerPage extends AbstractPage {
	WebDriver driver;

	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerID(String customerId) {
		waitForControlVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TXT, customerId);
	}

	public void ClickAccSubmit() {
		clickToElement(driver, EditCustomerPageUI.ACCOUNT_SUBMIT_BTN);
	}

	public void inputAddress(String address) {
		waitForControlVisible(driver, EditCustomerPageUI.ADDRESS_TXT);
		ClearToElement(driver, EditCustomerPageUI.ADDRESS_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.ADDRESS_TXT, address);
	}

	public void inputCity(String city) {
		ClearToElement(driver, EditCustomerPageUI.CITY_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.CITY_TXT, city);
	}

	public void inputPin(String pin) {
		ClearToElement(driver, EditCustomerPageUI.PIN_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.PIN_TXT, pin);
	}

	public void inputState(String state) {
		ClearToElement(driver, EditCustomerPageUI.STATE_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.STATE_TXT, state);
	}

	public void inputMobile(String mobile) {
		ClearToElement(driver, EditCustomerPageUI.TELEPHONE_NUMBER_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.TELEPHONE_NUMBER_TXT, mobile);
	}

	public void inputEmail(String email) {
		ClearToElement(driver, EditCustomerPageUI.EMAIL_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.EMAIL_TXT, email);
	}

	public void clickSubmit() {
		clickToElement(driver, EditCustomerPageUI.ACCOUNT_SUBMIT_BTN);
	}

	public String getMessage() {
		waitForControlVisible(driver, EditCustomerPageUI.SUCCESS_MES);
		return getTextElement(driver, EditCustomerPageUI.SUCCESS_MES);
	}

	public String getAddress() {
		return getTextElement(driver, EditCustomerPageUI.ADDRESS_EDITED);
	}

	public String getCity() {
		return getTextElement(driver, EditCustomerPageUI.CITY_EDITED);
	}

	public String getState() {
		return getTextElement(driver, EditCustomerPageUI.STATE_EDITED);
	}

	public String getPin() {
		return getTextElement(driver, EditCustomerPageUI.PIN_EDITED);
	}

	public String getMobileNumber() {
		return getTextElement(driver, EditCustomerPageUI.TELEPHONE_NUMBER_EDITED);
	}

	public String getEmail() {
		return getTextElement(driver, EditCustomerPageUI.EMAIL_EDITED);
	}

	public String getCustomerId() {
		return getTextElement(driver, EditCustomerPageUI.CUSTOMER_ID_EDITED);
	}

}
