package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.AbstractPageUI;
import pages.BalanceEnquiryPage;
import pages.DeleteAccountPage;
import pages.DeleteCustomerPage;
import pages.DepositPage;
import pages.EditCustomerPage;
import pages.FundTransferPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;
import pages.WithdrawalPage;

public class AbstractPage {
	// WebBrowser
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// WebElement
	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void ClearToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String text) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(text);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String text) {
		String checkField = value;
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		if (!checkField.equals("dob")) {
			element.clear();
		}
		element.sendKeys(text);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value, String item) {
		locator = String.format(locator, value);
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttribute(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int getSize(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			executeForWebElementByClick(driver, element);
		}
	}

	public Boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public Boolean isControlDisplayed(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public Boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public Boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	// Alert
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public void senkeyToAlert(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	// Windows
	public void switchToChildWindow(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	// Actions
	public void doubleClick(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void hoverMouse(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(locator));
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		WebElement sourceElement = driver.findElement(By.xpath(sourceLocator));
		WebElement targetElement = driver.findElement(By.xpath(targetLocator));
		action.dragAndDrop(sourceElement, targetElement).perform();
		action.release();
	}

	public void keyPress(WebDriver driver, String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(key);
	}

	// Upload
	public void Upload(WebDriver driver, String locator, String filePath) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(filePath);
	}

	// JavascriptExecutor
	public void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public Object executeForWebBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeForWebElementByClick(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object removeAttributeInDOM(WebDriver driver, WebElement element, String attribute) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottomPage(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object navigateToAnyUrl(WebDriver driver, String url) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// Wait
	public void waitForControlPresence(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForControlVisible(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForControlClickable(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForControlNotVisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForAlertPress(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/*---------OPEN NEW PAGE DYNAMIC XPATH---------*/
	public NewCustomerPage openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "New Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "New Customer");
		return PageFactoryManager.getNewCustomerPage(driver);
	}

	public EditCustomerPage openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Edit Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Edit Customer");
		return PageFactoryManager.getEditCustomerPage(driver);
	}

	public DeleteCustomerPage openDeleteCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Delete Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Delete Customer");
		return PageFactoryManager.getDeleteCustomerPage(driver);
	}

	public NewAccountPage openNewAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "New Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "New Account");
		return PageFactoryManager.getNewAccountPage(driver);
	}

	public DepositPage openDepositPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Deposit");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Deposit");
		return PageFactoryManager.getDepositPage(driver);
	}

	public WithdrawalPage openWithdrawalPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Withdrawal");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Withdrawal");
		return PageFactoryManager.getWithdrawalPage(driver);
	}

	public FundTransferPage openFundTransferPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Fund Transfer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Fund Transfer");
		return PageFactoryManager.getFundTransferPage(driver);
	}

	public BalanceEnquiryPage openBalanceEnquiryPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Balance Enquiry");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Balance Enquiry");
		return PageFactoryManager.getBalanceEnquiryPage(driver);
	}

	public DeleteAccountPage openDeleteAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Delete Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE, "Delete Account");
		return PageFactoryManager.getDeleteAccountPage(driver);
	}
}
