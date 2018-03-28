package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUI;

public class HomePage extends AbstractPage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHomepageMessage() throws InterruptedException {
		waitForControlVisible(driver, HomePageUI.WELCOM_MES);
		return getTextElement(driver, HomePageUI.WELCOM_MES);
	}
}
