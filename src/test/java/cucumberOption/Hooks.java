package cucumberOption;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import commons.Constant;
import cucumber.api.java.Before;

public class Hooks {
	private static WebDriver driver;
	private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

	@Before
	public synchronized static WebDriver openBrowser() {
		String browser = System.getProperty("BROWSER");

		if (driver == null) {
			try {
				if (browser == null) {
					browser = System.getenv("BROWSEr");
					if (browser == null) {
						browser = "chrome";
					}
				}
				switch (browser) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				case "ie":
					System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
				default:
					System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				}

			} catch (UnreachableBrowserException e) {
				driver = new ChromeDriver();
			} catch (WebDriverException e) {
				driver = new ChromeDriver();
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}
			driver.get(Constant.URL_BANK);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
			if (driver != null) {
				openBrowser().quit();
				System.out.println("------------Closing the browser------------");
			}
		} catch (UnreachableBrowserException e) {
			System.out.println("------------Cannot close browser : unreachable browser-------------");
		}

	}

	// public static void closeBrowser() {
	// try {
	// if (driver != null) {
	// driver.quit();
	// System.gc();
	// if (driver.toString().toLowerCase().contains("chrome")) {
	// String cmd = "taskkill /IM chromedriver.exe /F";
	// Process process = Runtime.getRuntime().exec(cmd);
	// process.waitFor();
	// }
	// if (driver.toString().toLowerCase().contains("ie")) {
	// String cmd = "taskkill /IM IEDriverServer.exe /F";
	// Process process = Runtime.getRuntime().exec(cmd);
	// process.waitFor();
	// }
	// // LOGGER.info("----------QUIT BROWSER----------");
	// System.out.println("----------QUIT BROWSER----------");
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println(e.getMessage());
	// }
	// }

}
