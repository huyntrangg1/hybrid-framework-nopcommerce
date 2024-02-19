package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.datatable.HomePageObject;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = pageObjects.jQuery.datatable.PageGeneratorManager.getHomePage(driver);

	}

	// @Test
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

	// @Test
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

	// @Test
	public void Table_03_Enter_To_Header() {
		// Ham doc du lieu cua file country.txt
		// Luu vao 1 List<String> = Expected Value

		// Actual Value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedCountryValues);
	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();

		// Value de nhap lieu - tham so 1
		// Row number: tai row nao?
		// td - column & tr - row
		// Ex: Nhap vao textbox tai line 3/5/2
		// Column name: Album/Artist/Year/Price
		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "2", "fsoft");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "4", "9876543");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "3", "1");

		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Japan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "5", "Hong Kong");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "7", "Taiwan");

		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "5");

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.clickToIconByRowNumber("8", "Remove Current Row");
		homePage.clickToIconByRowNumber("7", "Remove Current Row");
		homePage.clickToIconByRowNumber("6", "Remove Current Row");

		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");

		homePage.pickDateOfMemberSince("Member Since", "1", "09252013");
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
