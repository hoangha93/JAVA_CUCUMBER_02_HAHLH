package cucumberOption;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import cucumber.api.java.Before;

public class Hooks {
	private static WebDriver driver;
	private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

	@Before
	public synchronized static WebDriver openBrowser() {
		if (driver == null) {
			try {
				System.setProperty("webdriver.chrome.driver", "\\driver\\chromedriver.exe");
				driver = new FirefoxDriver();
			} catch (UnreachableBrowserException e) {
				driver = new FirefoxDriver();
			} catch (WebDriverException e) {
				driver = new FirefoxDriver();
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}
			driver.get("http://demo.guru99.com/v4/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// LOGGER.info("----------START BROWSER----------");
			System.out.println("----------START BROWSER----------");
		}
		return driver;
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			close();
		}
	}

	public static void close() {
		try {
			openBrowser().quit();
			driver = null;
			LOGGER.info("Closing the browser");
		} catch (UnreachableBrowserException e) {
			LOGGER.info("Cannot close browser : unreachable browser");
		}

	}

	public static void closeBrowser() {
		try {
			if (driver != null) {
				driver.quit();
				System.gc();
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
				// LOGGER.info("----------QUIT BROWSER----------");
				System.out.println("----------QUIT BROWSER----------");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
