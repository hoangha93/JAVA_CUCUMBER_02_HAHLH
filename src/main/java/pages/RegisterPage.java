package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import interfaces.RegisterPageUI;

public class RegisterPage extends AbstractPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmal(String email) throws InterruptedException {
		waitForControlVisible(driver, RegisterPageUI.EMAIL_TXT);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TXT, email);
	}

	public void clickSubmit() {
		clickToElement(driver, RegisterPageUI.LOGIN_BTN);
	}

	public String getUsername() {
		return getTextElement(driver, RegisterPageUI.USERNAME_TXT);
	}

	public String getPassword() {
		return getTextElement(driver, RegisterPageUI.PASSWORD_TXT);
	}

	public LoginPage openToUrl(String loginUrl) {
		openUrl(driver, loginUrl);
		return PageFactoryManager.getLoginPage(driver);
	}
}
