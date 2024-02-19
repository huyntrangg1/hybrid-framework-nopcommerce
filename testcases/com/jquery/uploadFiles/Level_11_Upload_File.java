package com.jquery.uploadFiles;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_11_Upload_File extends BaseTest {
	private WebDriver driver;
	private pageObjects.jQuery.uploadFiles.HomePageObject homePage;
	String csharpFileName = "CSharp.png";
	String javaFileName = "Java.png";
	String pythonFileName = "Python.png";
	String[] multipleFileNames = { csharpFileName, javaFileName, pythonFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = pageObjects.jQuery.uploadFiles.PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		// Step 01 - Load single file
		homePage.uploadMultipleFiles(driver, csharpFileName);

		// Step 02 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadByName(csharpFileName));

		// Step 03 - Click to start button
		homePage.clickToStartButton();

		// Step 04 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileUploadByName(csharpFileName));

		// Step 05 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadByName(csharpFileName));
	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		// Step 01 - Load single file

		homePage.uploadMultipleFiles(driver, multipleFileNames);
		// Step 02 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadByName(pythonFileName));

		// Step 03 - Click to start button
		homePage.clickToStartButton();

		// Step 04 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileUploadByName(csharpFileName));
		Assert.assertTrue(homePage.isFileUploadByName(javaFileName));
		Assert.assertTrue(homePage.isFileUploadByName(pythonFileName));

		// Step 05 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadByName(pythonFileName));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
