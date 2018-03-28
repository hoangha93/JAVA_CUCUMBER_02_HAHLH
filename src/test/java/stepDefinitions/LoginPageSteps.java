package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	WebDriver driver;

	@Given("^I navigate to bank guru site$")
	public void iNavigateToBankGuruSite() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
	}

	@When("^I input username and password$")
	public void iInputUsernameAndPassword() {
		driver.findElement(By.xpath("//*[@name='uid']")).sendKeys("mngr125143");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("vYhEpab");
	}

	@When("^I click to Login button$")
	public void iClickToLoginButton() {
		driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
	}

	@Then("^I verify Homepage displayed$")
	public void iVerifyHomepageDisplayed() {
		WebElement homePageMess = driver.findElement(By.xpath(
				"//marquee[@class='heading3' and contains(text(),\"Welcome To Manager's Page of Guru99 Bank\")]"));
		Assert.assertTrue(homePageMess.isDisplayed());
	}

	@And("^I quit browser$")
	public void iQuitBrowser() {
		driver.quit();
	}
}
