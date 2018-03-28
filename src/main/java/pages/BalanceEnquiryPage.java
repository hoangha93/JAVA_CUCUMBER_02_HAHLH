package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.BalanceEnquiryPageUI;

public class BalanceEnquiryPage extends AbstractPage {
	WebDriver driver;

	public BalanceEnquiryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAccountID(String accountID) {
		waitForControlVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TXT, accountID);
	}

	public void clickSubmitButton() {
		clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BTN);
	}

	public String getHeadingSuccess() {
		waitForControlVisible(driver, BalanceEnquiryPageUI.HEADING_MES);
		return getTextElement(driver, BalanceEnquiryPageUI.HEADING_MES);
	}

	public String getAmount() {
		return getTextElement(driver, BalanceEnquiryPageUI.BALANCE_TXT);
	}
}
