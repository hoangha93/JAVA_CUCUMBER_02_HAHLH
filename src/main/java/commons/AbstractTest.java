package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class AbstractTest {
	WebDriver driver;
	public Log log;

	public AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver runMultiBrowser(String browser, String version) {
		if (browser.equalsIgnoreCase("firefox")) {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			InternetExplorerDriverManager.getInstance().version(version).arch32().setup();
			driver = new InternetExplorerDriver();
		}
		driver.get(Constant.URL_BANK);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(9999) + 1;
		return number;
	}

	public boolean verifyPassed(boolean condition, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				if (condition == true) {
					log.info("=====PASSED====");
				} else
					log.info("=====FAILD=====");
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}

		} else {
			Assert.assertTrue(condition);
		}
		return pass;
	}

	public boolean verifyTrue(boolean condition) {
		return verifyPassed(condition, false);
	}

	public boolean verifyFailed(boolean condition, boolean flag) {
		boolean pass = true;
		if (flag = false) {
			try {
				if (condition == false)
					log.info("===PASSED===");
				else
					log.info("===FAILED===");
				Assert.assertFalse(condition);

			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;
	}

	public boolean verifyFalse(boolean condition) {
		return verifyFailed(condition, false);
	}

	public boolean verifyEquals(Object actual, Object expected, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				Assert.assertEquals(actual, expected);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertEquals(actual, expected);
		}
		return pass;
	}

	public boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}

	public void closeBrowser() {
		try {
			driver.quit();
			if (driver.toString().toLowerCase().contains("chrome")) {
				String cmd = "taskill /IM chromedriver.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("ie")) {
				String cmd = "taskill /IM IEDriverServer.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
