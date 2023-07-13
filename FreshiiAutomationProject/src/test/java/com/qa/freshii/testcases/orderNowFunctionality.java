package com.qa.freshii.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freshii.qa.base.TestBase;
import com.freshii.qa.pages.LaunchPage;
import com.freshii.qa.pages.OrderNowPage;

public class orderNowFunctionality extends TestBase {

	LaunchPage launchPage;
	OrderNowPage orderNowPage;

	public orderNowFunctionality() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		launchPage = new LaunchPage();
		launchPage.enterFindStore(prop.getProperty("postalCode"));
		Thread.sleep(5000);
		launchPage.navigateToLoginPage();
		Thread.sleep(3000);
		orderNowPage = launchPage.signInWithGoogleAccount(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 0)
	public void orderNowFunctionalityValidation() throws InterruptedException {
		orderNowPage.orderNowFunctionality();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
