package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.FundTransferPageUI;

public class FundTransferPage extends AbstractPage {
	WebDriver driver;

	public FundTransferPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputPayersAccount(String accountID) {
		waitForControlVisible(driver, FundTransferPageUI.PAYERS_NO_TXT);
		sendkeyToElement(driver, FundTransferPageUI.PAYERS_NO_TXT, accountID);
	}

	public void inputPayeesAccount(String payeesAccount) {
		sendkeyToElement(driver, FundTransferPageUI.PAYEES_NO_TXT, payeesAccount);
	}

	public void inputAmount(String amountFundTransfer) {
		sendkeyToElement(driver, FundTransferPageUI.AMOUNT_TXT, amountFundTransfer);
	}

	public void inputDescription(String descriptionFundTransfer) {
		sendkeyToElement(driver, FundTransferPageUI.DESCRIPTION_TXT, descriptionFundTransfer);
	}

	public void clickSubmitButton() {
		clickToElement(driver, FundTransferPageUI.SUBMIT_BTN);
	}

	public String getMessageSuccess() {
		waitForControlVisible(driver, FundTransferPageUI.SUCCESS_MES);
		return getTextElement(driver, FundTransferPageUI.SUCCESS_MES);
	}

	public String getAmount() {
		return getTextElement(driver, FundTransferPageUI.AMOUNT_TRANSFER_TXT);
	}

	public String getToAccountNumber() {
		return getTextElement(driver, FundTransferPageUI.TO_ACCOUNT_NUMBER);
	}

	public String getDescription() {
		return getTextElement(driver, FundTransferPageUI.DESCRIPTION);
	}
}
