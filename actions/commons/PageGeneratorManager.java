package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.nopcommerce.AdminDashboardPageObject;
import pageObjects.admin.nopcommerce.AdminLoginPageObject;
import pageObjects.portal.nopcommerce.UserAddressPageObject;
import pageObjects.portal.nopcommerce.UserCustomerInforPageObject;
import pageObjects.portal.nopcommerce.UserHomePageObject;
import pageObjects.portal.nopcommerce.UserLoginPageObject;
import pageObjects.portal.nopcommerce.UserMyProductReviewPageObject;
import pageObjects.portal.nopcommerce.UserRegisterPageObject;
import pageObjects.portal.nopcommerce.UserRewardPointPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
}
