package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewCustomerPageUI;

public class NewCustomerPage extends AbstractPage {
	WebDriver driver;

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getCustomerId() {
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID_TXT);
	}
}
