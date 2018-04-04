package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import interfaces.LoginPageUI;

public class LoginPage extends AbstractPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return getCurrentUrl(driver);
	}

	public RegisterPage clickHereLink() {
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
	}

	public void inputUserName(String user){
		waitForControlVisible(driver, LoginPageUI.USENAME_TXT);
		sendkeyToElement(driver, LoginPageUI.USENAME_TXT, user);
	}

	public void inputPassword(String password) {
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}

	public HomePage clickLogin() {
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
		return PageFactoryManager.getHomePage(driver);

	}
}
