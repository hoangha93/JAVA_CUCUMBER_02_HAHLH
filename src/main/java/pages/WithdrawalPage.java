package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.WithdrawalPageUI;

public class WithdrawalPage extends AbstractPage {
	WebDriver driver;

	public WithdrawalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAcountNo(String accountID) {
		waitForControlVisible(driver, WithdrawalPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, WithdrawalPageUI.ACCOUNT_NO_TXT, accountID);
	}

	public void inputAmount(String amountWithdrawal) {
		sendkeyToElement(driver, WithdrawalPageUI.AMOUNT_TXT, amountWithdrawal);
	}

	public void inputDescription(String descriptionWithdrawal) {
		sendkeyToElement(driver, WithdrawalPageUI.DESCRIPTION_TXT, descriptionWithdrawal);
	}

	public void clickSubmitButton() {
		clickToElement(driver, WithdrawalPageUI.SUBMIT_BTN);

	}

	public String getMessageSuccess(){
		waitForControlVisible(driver, WithdrawalPageUI.SUCCESS_MES);
		return getTextElement(driver, WithdrawalPageUI.SUCCESS_MES);
	}

	public String getCurrenttBalance() {
		return getTextElement(driver, WithdrawalPageUI.CURRENT_BALANCE);
	}

	public String getAccountId() {
		return getTextElement(driver, WithdrawalPageUI.ACCOUNT_NO);
	}

	public String getAmountDebited() {
		return getTextElement(driver, WithdrawalPageUI.AMOUNT_DEBITED);
	}

	public String getDescription() {
		return getTextElement(driver, WithdrawalPageUI.DESCRIPTION);
	}

}
