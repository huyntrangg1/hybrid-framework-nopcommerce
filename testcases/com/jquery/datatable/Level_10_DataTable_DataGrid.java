package com.jquery.datatable;

import java.util.List;

import org.checkerframework.checker.units.qual.Acceleration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = pageObjects.jQuery.PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("5");
		Assert.assertTrue(homePage.isPageNumberActived("5"));

		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("12");
		Assert.assertTrue(homePage.isPageNumberActived("12"));

	}

	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshdToPage(driver);
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");

		homePage.sleepInSecond(3);

		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(3);
	}

	@Test
	public void Table_03_Enter_To_Header() {
		// Ham doc du lieu cua file country.txt
		// Luu vao 1 List<String> = Expected Value

		// Actual Value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedCountryValues);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
