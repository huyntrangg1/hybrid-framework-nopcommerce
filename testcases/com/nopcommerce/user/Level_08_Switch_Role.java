package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.admin.nopcommerce.AdminDashboardPageObject;
import pageObjects.admin.nopcommerce.AdminLoginPageObject;
import pageObjects.portal.nopcommerce.UserAddressPageObject;
import pageObjects.portal.nopcommerce.UserCustomerInforPageObject;
import pageObjects.portal.nopcommerce.UserHomePageObject;
import pageObjects.portal.nopcommerce.UserLoginPageObject;
import pageObjects.portal.nopcommerce.UserMyProductReviewPageObject;
import pageObjects.portal.nopcommerce.UserRegisterPageObject;
import pageObjects.portal.nopcommerce.UserRewardPointPageObject;

public class Level_08_Switch_Role extends BaseTest {

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private WebDriver driver;
	private String userFirstName, userLastName, userEmailAddress, userPassword, adminEmailAddress, adminPassword;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userFirstName = "Automation";
		userLastName = "Fc";
		userEmailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
		
	}

	@Test
	public void TC_01_User_01_Register() {
		System.out.println("Pre-condition - Step 01: Click to Register link");
		userRegisterPage = userHomePage.openRegisterPage();

		System.out.println("Pre-condition - Step 02: Input to require field");
		userRegisterPage.inputToFirstnameTextbox(userFirstName);
		userRegisterPage.inputToLastnameTextbox(userLastName);
		userRegisterPage.inputToEmailTextbox(userEmailAddress);
		userRegisterPage.inputToPasswordTextbox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(userPassword);

		System.out.println("Pre-condition - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();

		System.out.println("Pre-condition - Step 04: Verify success message displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void TC_02_Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();

		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// Home page -> Customer info
		userCustomerInforPage = userHomePage.openMyAccountPage();

		// Customer info click logout -> Home page
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);

		// User home page -> open admin page
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_TEST_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

		// Dashoboard page -> Click logout -> login page (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);

	}

	@Test
	public void TC_03_Role_02_Admin_To_User() {
		// Login page admin -> open portal url -> user homepage
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_TEST_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		// Homepage -> Login page user
		userLoginPage = userHomePage.openLoginPage();

		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// Home page -> Customer info
		userCustomerInforPage = userHomePage.openMyAccountPage();

		// Customer info click logout -> Home page
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

}
