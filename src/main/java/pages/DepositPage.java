package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DepositPageUI;

public class DepositPage extends AbstractPage {
	WebDriver driver;

	public DepositPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAmount(String amount) {
		sendkeyToElement(driver, DepositPageUI.AMOUNT_TXT, amount);
	}

	public void inputDescription(String description) {
		sendkeyToElement(driver, DepositPageUI.DESCRIPTION_TXT, description);
	}
}
