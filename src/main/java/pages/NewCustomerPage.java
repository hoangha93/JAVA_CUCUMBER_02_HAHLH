package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewCustomerPageUI;

public class NewCustomerPage extends AbstractPage {
	WebDriver driver;

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerName(String customerName) {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TXT);
		ClearToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TXT, customerName);
	}

	public void inputDateOfBirth(String dOB) {
		sendkeyToElement(driver, NewCustomerPageUI.DAY_OF_BIRTH_TXT, dOB);
	}

	public void inputAddress(String address) {
		ClearToElement(driver, NewCustomerPageUI.ADDRESS_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TXT, address);
	}

	public void inputCity(String city) {
		ClearToElement(driver, NewCustomerPageUI.CITY_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.CITY_TXT, city);
	}

	public void inputPin(String pin) {
		ClearToElement(driver, NewCustomerPageUI.PIN_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.PIN_TXT, pin);
	}

	public void inputState(String state) {
		ClearToElement(driver, NewCustomerPageUI.STATE_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.STATE_TXT, state);
	}

	public void inputMobile(String mobile) {
		ClearToElement(driver, NewCustomerPageUI.TELEPHONE_NUMBER_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.TELEPHONE_NUMBER_TXT, mobile);
	}

	public void inputEmail(String email) {
		ClearToElement(driver, NewCustomerPageUI.EMAIL_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.EMAIL_TXT, email);
	}

	public void inputPassword(String password) {
		sendkeyToElement(driver, NewCustomerPageUI.PASSWORD_TXT, password);
	}

	public void clickSubmit() {
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BTN);
	}

	public String getMessage() {
		waitForControlVisible(driver, NewCustomerPageUI.SUCCESS_MES);
		return getTextElement(driver, NewCustomerPageUI.SUCCESS_MES);
	}

	public String getCustomerId() {
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID_TXT);
	}
	
	public String getCustomerName() {
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_CREATED);
	}

	public String getDateOfBirth() {
		return getTextElement(driver, NewCustomerPageUI.DAY_OF_BIRTH_CREATED);
	}

	public String getAddress() {
		return getTextElement(driver, NewCustomerPageUI.ADDRESS_CREATED);
	}

	public String getCity() {
		return getTextElement(driver, NewCustomerPageUI.CITY_CREATED);
	}

	public String getState() {
		return getTextElement(driver, NewCustomerPageUI.STATE_CREATED);
	}

	public String getPin() {
		return getTextElement(driver, NewCustomerPageUI.PIN_CREATED);
	}

	public String getMobile() {
		return getTextElement(driver, NewCustomerPageUI.TELEPHONE_NUMBER_CREATED);
	}

	public String getEmail() {
		return getTextElement(driver, NewCustomerPageUI.EMAIL_CREATED);
	}

	public void pressTab() {
		keyPress(driver, NewCustomerPageUI.CUSTOMER_NAME_TXT, Keys.TAB);
	}

	public String getMessCustomerName() {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_MES);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_MES);
	}

	public String getMessAddress() {
		waitForControlVisible(driver, NewCustomerPageUI.ADDRESS_MES);
		return getTextElement(driver, NewCustomerPageUI.ADDRESS_MES);
	}

	public String getMessCity() {
		waitForControlVisible(driver, NewCustomerPageUI.CITY_MES);
		return getTextElement(driver, NewCustomerPageUI.CITY_MES);
	}

	public String getMessState() {
		waitForControlVisible(driver, NewCustomerPageUI.STATE_MES);
		return getTextElement(driver, NewCustomerPageUI.STATE_MES);
	}

	public String getMessPin() {
		waitForControlVisible(driver, NewCustomerPageUI.PIN_MES);
		return getTextElement(driver, NewCustomerPageUI.PIN_MES);
	}

	public String getMessTelephone() {
		waitForControlVisible(driver, NewCustomerPageUI.TELEPHONE_NUMBER_MES);
		return getTextElement(driver, NewCustomerPageUI.TELEPHONE_NUMBER_MES);
	}

	public String getMessEmail() {
		waitForControlVisible(driver, NewCustomerPageUI.EMAIL_MES);
		return getTextElement(driver, NewCustomerPageUI.EMAIL_MES);
	}
}
