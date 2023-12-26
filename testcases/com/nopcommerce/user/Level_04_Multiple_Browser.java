package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");

		homePage = new HomePageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		// Click register link -> direct to register page
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_01 - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
