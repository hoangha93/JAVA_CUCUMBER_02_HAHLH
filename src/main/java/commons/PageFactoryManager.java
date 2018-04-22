package commons;

import org.openqa.selenium.WebDriver;

import pages.AbstractPageObject;
import pages.BalanceEnquiryPage;
import pages.DeleteAccountPage;
import pages.DeleteCustomerPage;
import pages.DepositPage;
import pages.EditCustomerPage;
import pages.FundTransferPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;
import pages.RegisterPage;
import pages.WithdrawalPage;

public class PageFactoryManager {
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static RegisterPage registerPage;
	public static NewCustomerPage newCustomerPage;
	public static EditCustomerPage editCustomerPage;
	public static DeleteCustomerPage deleteCustomerPage;
	public static NewAccountPage newAccountPage;
	public static DepositPage depositPage;
	public static WithdrawalPage withdrawalPage;
	public static FundTransferPage fundTransferPage;
	public static BalanceEnquiryPage balanceEnquiryPage;
	public static DeleteAccountPage deleteAccountPage;
	public static AbstractPageObject abstractPage;

	public static LoginPage getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			return new LoginPage(driver);
		}
		return loginPage;
	}

	public static RegisterPage getRegisterPage(WebDriver driver) {
		if (registerPage == null) {
			return new RegisterPage(driver);
		}
		return registerPage;
	}

	public static HomePage getHomePage(WebDriver driver) {
		if (homePage == null) {
			return new HomePage(driver);
		}
		return homePage;
	}

	public static NewCustomerPage getNewCustomerPage(WebDriver driver) {
		if (newCustomerPage == null) {
			return new NewCustomerPage(driver);
		}
		return newCustomerPage;
	}

	public static EditCustomerPage getEditCustomerPage(WebDriver driver) {
		if (editCustomerPage == null) {
			return new EditCustomerPage(driver);
		}
		return editCustomerPage;
	}

	public static DeleteCustomerPage getDeleteCustomerPage(WebDriver driver) {
		if (deleteCustomerPage == null) {
			return new DeleteCustomerPage(driver);
		}
		return deleteCustomerPage;
	}

	public static NewAccountPage getNewAccountPage(WebDriver driver) {
		if (newAccountPage == null) {
			return new NewAccountPage(driver);
		}
		return newAccountPage;
	}

	public static DepositPage getDepositPage(WebDriver driver) {
		if (depositPage == null) {
			return new DepositPage(driver);
		}
		return depositPage;
	}

	public static WithdrawalPage getWithdrawalPage(WebDriver driver) {
		if (withdrawalPage == null) {
			return new WithdrawalPage(driver);
		}
		return withdrawalPage;
	}

	public static FundTransferPage getFundTransferPage(WebDriver driver) {
		if (fundTransferPage == null) {
			return new FundTransferPage(driver);
		}
		return fundTransferPage;
	}

	public static BalanceEnquiryPage getBalanceEnquiryPage(WebDriver driver) {
		if (balanceEnquiryPage == null) {
			return new BalanceEnquiryPage(driver);
		}
		return balanceEnquiryPage;
	}

	public static DeleteAccountPage getDeleteAccountPage(WebDriver driver) {
		if (deleteAccountPage == null) {
			return new DeleteAccountPage(driver);
		}
		return deleteAccountPage;
	}

	public static AbstractPageObject getAbstractPage(WebDriver driver) {
		if (abstractPage == null) {
			return new AbstractPageObject(driver);
		}
		return abstractPage;
	}
}
