package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DepositPageUI;

public class DepositPage extends AbstractPage {
	WebDriver driver;

	public DepositPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAcountNo(String accountID) {
		waitForControlVisible(driver, DepositPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, DepositPageUI.ACCOUNT_NO_TXT, accountID);
	}

	public void inputAmount(String amount) {
		sendkeyToElement(driver, DepositPageUI.AMOUNT_TXT, amount);
	}

	public void inputDescription(String description) {
		sendkeyToElement(driver, DepositPageUI.DESCRIPTION_TXT, description);
	}

	public String getMessageSuccess() {
		waitForControlVisible(driver, DepositPageUI.SUCCESS_MES);
		return getTextElement(driver, DepositPageUI.SUCCESS_MES);
	}

	public void clickSubmitButton() {
		clickToElement(driver, DepositPageUI.SUBMIT_BTN);
	}

	public String getCurrenttBalance() {
		return getTextElement(driver, DepositPageUI.CURRENT_BALANCE);
	}

	public String getAccountId() {
		return getTextElement(driver, DepositPageUI.ACCOUNT_NO);
	}

	public String getAmountCredited() {
		return getTextElement(driver, DepositPageUI.AMOUNT_CREDITED);
	}

	public String getTypeTransaction() {
		return getTextElement(driver, DepositPageUI.TYPE_TRANSACSION);
	}

	public String getDescription() {
		return getTextElement(driver, DepositPageUI.DESCRIPTION_TRANSACTION);
	}

}
