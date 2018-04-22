package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewAccountPageUI;

public class NewAccountPage extends AbstractPage {
	WebDriver driver;

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getAccountID() {
		return getTextElement(driver, NewAccountPageUI.ACCOUNT_ID_TXT);
	}

}
