package com.nopcommerce.user;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_III extends BasePage {
	WebDriver driver;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getTextElement(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getTextElement(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getTextElement(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", "123@345#%S");
		sendkeyToElement(driver, "//input[@id='Password']", "123455");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123455");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123455");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123455");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getTextElement(driver, "//div[@class='result']"), "Your registration completed");
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "Fc");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123455");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123455");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getTextElement(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getTextElement(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123455");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

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
