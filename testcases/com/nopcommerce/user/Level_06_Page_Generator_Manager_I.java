package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private WebDriver driver;
	private String firstName, lastName, emailAddress, existingEmail, invalidEmail, notFoundEmail, password, incorrectPassword;
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");

		// Cách khởi tạo 1: Cho việc khởi tạo page object trực tiếp ở trên testcase
		// Ưu điểm: - 0 bị lỗi NullPointer (1 class mang ra sử dụng nhưng chưa được khởi tạo)
		// Nhược điểm: 	- Hiển thị việc khởi tạo page/ class ở trên testcase luôn (0 tuân theo tính chất đóng gói/ che giấu sự khởi tạo của 1 đối tượng)
		// 				- Bị lặp lại nhiều lần việc khởi tạo
		homePage = new HomePageObject(driver);
		firstName = "Automation";
		lastName = "Fc";
		invalidEmail = "afc@com.@vn";
		notFoundEmail = "afc" + generateFakeNumber() + "@mail.vn";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";
		incorrectPassword = "123098";

		System.out.println("Pre-condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-condition - Step 02: Input to require field");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// System.out.println("Register Page - Step 05: Click logout link");
		// registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Not_Found_Email() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_03_Invalid_Email() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_InvalidPassword() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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
