package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;

public class AbstractPageObject extends AbstractPage {
	WebDriver driver;

	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickDynamicButton(String buttonName) {
		clickToElement(driver, AbstractPageUI.DYNAMIC_BTN,buttonName);
	}

	public boolean isNewEditDisplay(String message) {
		waitForControlVisible(driver, AbstractPageUI.CHECK_DYNAMIC_NEW_EDIT_CUSTOMER_DISPLAY, message);
		return isControlDisplayed(driver, AbstractPageUI.CHECK_DYNAMIC_NEW_EDIT_CUSTOMER_DISPLAY, message);
	}

	public void inputToDynamicTextbox(String textboxName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, textboxName);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, textboxName, value);
	}

	public void inputToDynamicTextArea(String textAreaName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA, textAreaName);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA, textAreaName, value);
	}

	public void clickToDynamicRadioButton(String radioButtonValue) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON,radioButtonValue);
		clickToElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonValue);
	}

	public String getDataDynamic(String customerName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DATA_NEW_CREATED,customerName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_DATA_NEW_CREATED, customerName);
	}

	public void selectToDynamicDropDownList(String selectName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST,selectName);
		selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, selectName,value);
	}

	public void inputAccountNo(String firstAccountId) {
		waitForControlVisible(driver, AbstractPageUI.CUSTOMER_ID);
		sendkeyToElement(driver, AbstractPageUI.CUSTOMER_ID, firstAccountId);
	}

}
